(ns clj-xml-fo.core-test
  (:require [clj-xml-fo.core :as fo]
            [clj-xml-fo.test-docs :as docs :refer [doc hello rendered-text]]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.test :refer [deftest is testing]]
            [malli.core :as m]
            [malli.error :as me])
  (:import (clojure.lang ExceptionInfo)
           (java.io ByteArrayOutputStream File)
           (org.xml.sax.helpers DefaultHandler)))

(defn- errors
  ([x] (errors x {}))
  ([x opts] (me/humanize (fo/explain x opts))))

(defn- ex-data-of [f]
  (try (f) nil (catch ExceptionInfo e (ex-data e))))

;; ---------------------------------------------------------------------------
;; Validation
;; ---------------------------------------------------------------------------

(deftest valid-documents-and-fragments
  (is (fo/valid? hello))
  (is (= hello (fo/validate hello)))
  (is (nil? (fo/explain hello)))
  (testing "any element validates on its own, chosen by its tag"
    (is (fo/valid? [:block {:xml/value ["text"]}]))
    (is (fo/valid? (get-in hello [1 :page-sequence 0 :flow :xml/value 1])))
    (is (fo/valid? [:table-row {:table-cell [(docs/cell "x")]}])))
  (testing "an empty mixed-content element needs no :xml/value"
    (is (fo/valid? [:block {}])))
  (testing "table-body takes its rows as a flat sequence"
    (is (fo/valid? [:table-body {:xml/value [[:table-row {:table-cell [(docs/cell "x")]}]
                                             [:table-row {:table-cell [(docs/cell "y")]}]]}]))))

(deftest invalid-data
  (testing "attribute value outside fop.xsd"
    (let [bad (assoc-in hello [1 :page-sequence 0 :flow :xml/value 0 1 :font-size] "huge")]
      (is (not (fo/valid? bad)))
      (is (contains? (get-in (errors bad) [1 :page-sequence 0 :flow :xml/value 0 1]) :font-size))))
  (testing "a misspelt attribute is a disallowed key, not silently dropped"
    (is (= {:fnot-size ["disallowed key"]}
           (second (errors [:block {:fnot-size "12pt"}])))))
  (testing "anything that is not an element is invalid, not an exception"
    (is (not (fo/valid? 42)))
    (is (not (fo/valid? (doc [42]))))
    (is (some? (fo/explain "text"))))
  (testing "mixed content is a vector of children, never a single element"
    (let [footgun [:block {:xml/value [:inline {:font-weight "bold"} "x"]}]]
      (is (not (fo/valid? footgun)))
      (is (not (fo/valid? footgun {:lenient? true})))
      (is (fo/valid? [:block {:xml/value [[:inline {:font-weight "bold"} "x"]]}]))))
  (testing "unknown element"
    (is (not (fo/valid? [:blok {}])))
    (is (= ::fo/unknown-element (:type (ex-data-of #(fo/schema :blok))))))
  (testing "a required child"
    (is (= {:layout-master-set ["missing required key"] :page-sequence ["missing required key"]}
           (second (errors [:root {}])))))
  (testing "validate throws with humanized errors"
    (let [data (ex-data-of #(fo/validate [:block {:color "not a colour"}]))]
      (is (= ::fo/invalid (:type data)))
      (is (= :block (:tag data)))
      (is (contains? (second (:errors data)) :color)))))

(deftest strict-and-lenient
  (testing "fop.xsd is narrower than FOP; lenient accepts any string value"
    (doseq [el [[:block {:color "#ff0000"}]
                [:block {:space-before "0"}]
                [:block {:language "en"}]
                [:list-item-label {:end-indent "label-end()" :xml/value [[:block {}]]}]]]
      (is (not (fo/valid? el)) (pr-str el))
      (is (fo/valid? el {:lenient? true}) (pr-str el))))
  (testing "lenient still checks structure and attribute names"
    (is (not (fo/valid? [:block {:fnot-size "12pt"}] {:lenient? true})))
    (is (not (fo/valid? [:block {:color 12}] {:lenient? true})))
    (is (not (fo/valid? [:root {}] {:lenient? true})))))

(deftest registry-composes
  (is (m/validate [:vector :clj-xml-fo.element/block]
                  [[:block {:xml/value ["a"]}] [:block {}]]
                  {:registry (fo/registry)}))
  (is (= :clj-xml-fo.element/table (m/form (fo/schema :table)))))

;; ---------------------------------------------------------------------------
;; Encoding
;; ---------------------------------------------------------------------------

(deftest xml-output
  (let [xml (fo/xml-string hello)]
    (is (str/includes? xml "<fo:root xmlns:fo=\"http://www.w3.org/1999/XSL/Format\">"))
    (is (str/includes? xml "<fo:block font-size=\"14pt\">Hello, <fo:inline font-weight=\"bold\">world</fo:inline>!</fo:block>"))
    (is (str/includes? xml "<fo:table-column column-width=\"50%\"/>"))
    (is (not (str/includes? xml "<root")) "no element escapes the fo namespace")))

(deftest encode-into-any-content-handler
  (let [elements (atom [])
        handler (proxy [DefaultHandler] []
                  (startElement [uri local _qname _attrs]
                    (swap! elements conj [uri local])))]
    (fo/encode! hello handler)
    (is (= [fo/fo-ns "root"] (first @elements)))
    (is (every? #(= fo/fo-ns (first %)) @elements))
    (is (= 2 (count (filter #(= "table-row" (second %)) @elements))))))

(deftest silently-dropped-without-validation
  (testing "the unparser writes only keys the schema knows"
    (is (not (str/includes? (fo/xml-string [:block {:fnot-size "12pt" :xml/value ["x"]}]) "fnot"))))
  (testing ":validate? refuses instead"
    (is (= ::fo/invalid (:type (ex-data-of #(fo/xml-string [:block {:fnot-size "12pt"}] {:validate? true})))))))

;; ---------------------------------------------------------------------------
;; FOP
;; ---------------------------------------------------------------------------

(deftest renders-pdf
  (let [out (ByteArrayOutputStream.)
        result (fo/render! hello out)]
    (is (= 1 (:page-count result)))
    (is (= "%PDF-" (String. (.toByteArray out) 0 5 "US-ASCII")))))

(deftest renders-content
  (let [text (rendered-text hello)]
    (is (str/includes? text "Hello, world !"))
    (is (str/includes? text "a1"))
    (is (str/includes? text "b2"))))

(deftest renders-to-a-file
  (let [f (File/createTempFile "clj-xml-fo" ".pdf")]
    (try
      (is (= 1 (:page-count (fo/render! hello f))))
      (is (< 1000 (.length f)))
      (finally (io/delete-file f true)))))

(deftest render-with-validation
  (is (= 1 (:page-count (fo/render! hello (ByteArrayOutputStream.) {:validate? true}))))
  (testing "invalid data never reaches FOP"
    (let [out (ByteArrayOutputStream.)
          bad (assoc-in hello [1 :page-sequence 0 :master-reference] 42)]
      (is (= ::fo/invalid (:type (ex-data-of #(fo/render! bad out {:validate? true})))))
      (is (zero? (.size out))))))

(deftest mixed-content-is-hiccup
  (testing "elements inside a block use hiccup, down to a nested table"
    (let [d (doc [[:block {:xml/value ["Before "
                                       [:inline {:font-style "italic"} "inline"]
                                       [:table {:table-layout "fixed" :width "100%"}
                                        [:table-column {:column-width "100%"}]
                                        [:table-body
                                         [:table-row
                                          [:table-cell [:block "nested cell"]]]]]
                                       " after"]}]])]
      (is (fo/valid? d))
      (is (= "Before inline nested cell after" (rendered-text d))))))

(deftest foreign-content-in-its-namespace
  (let [svg-ns "http://www.w3.org/2000/svg"
        d (doc [[:block {:xml/value [[:instream-foreign-object {}
                                      [:svg {:xmlns svg-ns :width "20pt" :height "20pt"}
                                       [:rect {:width "10" :height "10" :fill "red"}]]]]}]])
        xml (fo/xml-string d)]
    (is (str/includes? xml (str "<svg xmlns=\"" svg-ns "\"")))
    (is (str/includes? xml "<rect width=\"10\" height=\"10\" fill=\"red\"/>"))
    (is (= 1 (:page-count (fo/render! d (ByteArrayOutputStream.)))))))
