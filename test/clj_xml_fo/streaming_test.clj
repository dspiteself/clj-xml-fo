(ns clj-xml-fo.streaming-test
  (:require [clj-xml-fo.core :as fo]
            [clj-xml-fo.test-docs :refer [doc rendered-words]]
            [clojure.string :as str]
            [clojure.test :refer [deftest is testing]])
  (:import (clojure.lang ExceptionInfo IReduceInit)
           (java.io ByteArrayOutputStream)
           (org.xml.sax.helpers DefaultHandler)))

(defn- block [i] [:block {:xml/value [(str "item " i)]}])

(defn- row [i]
  [:table-row {:table-cell [{:xml/value [(block i)]}
                            {:xml/value [[:block {:xml/value [(str (* i i))]}]]}]}])

(defn- table [rows]
  [:table {:table-layout "fixed" :width "100%"
           :table-column [{:column-width "30%"} {:column-width "70%"}]
           :table-body [{:xml/value rows}]}])

(defn- once
  "A reducible that fails if it is reduced a second time."
  [coll]
  (let [used (atom false)]
    (reify IReduceInit
      (reduce [_ f init]
        (when-not (compare-and-set! used false true)
          (throw (IllegalStateException. "reduced twice")))
        (reduce f init coll)))))

(deftest streams-encode-like-vectors
  (testing "flow content, table rows and page-sequences given as streams"
    (let [static (doc [(block 0) (table (mapv row (range 3))) (block 4)])
          streamed (doc (eduction cat [[(block 0)]
                                       [(table (eduction (map row) (range 3)))]
                                       (map block [4])]))]
      (is (= (fo/xml-string static) (fo/xml-string streamed)))))
  (testing "a lazy seq and a spliced stream among vector items"
    (is (= (fo/xml-string (doc (mapv block (range 5))))
           (fo/xml-string (doc (map block (range 5))))
           (fo/xml-string (doc [(block 0) (map block (range 1 4)) (block 4)])))))
  (testing "mixed content may stream too"
    (is (= (fo/xml-string (doc [[:block {:xml/value ["a" [:inline "b"] "c"]}]]))
           (fo/xml-string (doc [[:block {:xml/value (list "a" [:inline (map identity ["b"])] "c")}]]))))))

(deftest items-reach-the-handler-before-the-next-is-produced
  (let [log (atom [])
        handler (proxy [DefaultHandler] []
                  (startElement [_uri local _qname _attrs]
                    (when (= "block" local)
                      (swap! log conj :emitted))))
        items (eduction (map (fn [i] (swap! log conj :produced) (block i))) (range 4))]
    (fo/encode! (doc items) handler)
    (is (= (take 8 (cycle [:produced :emitted])) @log))))

(deftest a-stream-is-reduced-once
  (let [d (doc (once (mapv block (range 3))))]
    (is (str/includes? (fo/xml-string d {:validate? true}) "item 2"))))

(deftest page-sequences-stream-into-fop
  (let [d (assoc-in (doc []) [1 :page-sequence]
                    (eduction (map (fn [i] {:master-reference "A4"
                                            :flow {:flow-name "xsl-region-body"
                                                   :xml/value [(block i)]}}))
                              (range 5)))
        out (ByteArrayOutputStream.)
        result (fo/render! d out {:validate? true})]
    (is (= 5 (:page-count result)))
    (is (= 5 (count (:page-sequences result))))))

(deftest streamed-table-renders
  (is (= (mapcat (fn [i] ["item" (str i) (str (* i i))]) (range 200))
         (rendered-words (doc [(table (eduction (map row) (range 200)))])))))

(deftest streaming-validation
  (testing "each streamed item is validated as it arrives, with its path"
    (let [items (eduction (map (fn [i] (if (= i 3) [:block {:colour "red"}] (block i)))) (range 5))
          data (try (fo/xml-string (doc items) {:validate? true}) nil
                    (catch ExceptionInfo e (ex-data e)))]
      (is (= ::fo/invalid (:type data)))
      (is (= [1 :page-sequence 0 :flow :xml/value 3 1] (:path data)))
      (is (= {:colour ["disallowed key"]} (second (:errors data))))))
  (testing "streamed items must be elements the parent allows"
    (doseq [[item expected-path] [[[:blok {}] [1 :page-sequence 0 :flow :xml/value 1]]
                                  ["loose text" [1 :page-sequence 0 :flow :xml/value 1]]
                                  [[:table-row {:table-cell [{}]}] [1 :page-sequence 0 :flow :xml/value 1]]]]
      (let [data (try (fo/xml-string (doc (list (block 0) item)) {:validate? true}) nil
                      (catch ExceptionInfo e (ex-data e)))]
        (is (= ::fo/invalid (:type data)) (pr-str item))
        (is (= :flow (:tag data)) (pr-str item))
        (is (= expected-path (:path data)) (pr-str item)))))
  (testing "without :validate? an unknown element streams through, as sitoa writes it"
    (is (str/includes? (fo/xml-string (doc (list [:blok {}]))) "<fo:blok/>")))
  (testing "foreign hiccup is allowed where the schema allows it"
    (let [d (assoc-in (doc (list (block 0))) [1 :declarations]
                      {:xml/value (list [:color-profile {:src "x.icc" :color-profile-name "p"}]
                                        [:extension {:xmlns "urn:example"}])})]
      (is (str/includes? (fo/xml-string d {:validate? true}) "<extension xmlns=\"urn:example\"/>"))))
  (testing "an element opened around a stream must have its required keys"
    (let [d (update-in (doc (map block (range 2))) [1 :page-sequence 0 :flow] dissoc :flow-name)
          data (try (fo/xml-string d {:validate? true}) nil
                    (catch ExceptionInfo e (ex-data e)))]
      (is (= {:flow-name ["missing required key"]} (:errors data)))
      (is (= [1 :page-sequence 0 :flow] (:path data)))))
  (testing "an element opened around a stream has its own keys checked"
    (let [d (assoc-in (doc (map block (range 2))) [1 :page-sequence 0 :flow :flow-nmae] "x")
          data (try (fo/xml-string d {:validate? true}) nil
                    (catch ExceptionInfo e (ex-data e)))]
      (is (= ::fo/invalid (:type data)))
      (is (= {:flow-nmae ["disallowed key"]} (:errors data)))))
  (testing "lenient applies to streamed items"
    (is (string? (fo/xml-string (doc (map (fn [_] [:block {:color "#ff0000"}]) (range 2)))
                                {:validate? true :lenient? true})))))

(deftest hiccup-in-element-content-is-refused
  (let [d (doc (list [:block {:font-size "12pt"} "hiccup belongs in mixed content"]))
        data (try (fo/xml-string d) nil (catch ExceptionInfo e (ex-data e)))]
    (is (= :block (:tag data)))
    (is (= [1 :page-sequence 0 :flow :xml/value 0] (:path data)))))
