(ns clj-xml-fo.test-docs
  (:require [clj-xml-fo.core :as fo]
            [clojure.string :as str])
  (:import (java.io ByteArrayOutputStream)))

(defn doc
  "An A4 document whose flow holds items."
  [items]
  [:root
   {:layout-master-set
    {:xml/value [[:simple-page-master {:master-name  "A4"
                                       :page-width   "210mm"
                                       :page-height  "297mm"
                                       :region-body  {:margin "2cm"}}]]}
    :page-sequence
    [{:master-reference "A4"
      :flow             {:flow-name "xsl-region-body"
                         :xml/value items}}]}])

(defn cell [text]
  {:xml/value [[:block {:xml/value [text]}]]})

(def hello
  (doc [[:block {:font-size "14pt"
                 :xml/value ["Hello, " [:inline {:font-weight "bold"} "world"] "!"]}]
        [:table {:table-layout "fixed"
                 :width        "100%"
                 :table-column [{:column-width "50%"} {:column-width "50%"}]
                 :table-body   [{:xml/value [[:table-row {:table-cell [(cell "a1") (cell "b1")]}]
                                             [:table-row {:table-cell [(cell "a2") (cell "b2")]}]]}]}]]))

(defn render-text
  "Render with FOP's plain text renderer. It places text on a character grid
  and clips or overlaps what does not fit, so compare whole outputs with it
  rather than look for content."
  ([d] (render-text d {}))
  ([d opts]
   (let [out (ByteArrayOutputStream.)]
     (fo/render! d out (assoc opts :mime "text/plain"))
     (.toString out "UTF-8"))))

(defn rendered-words
  "The words FOP laid out, in order, read from its area tree."
  [d]
  (let [out (ByteArrayOutputStream.)]
    (fo/render! d out {:mime "application/X-fop-areatree"})
    (mapv second (re-seq #"<word[^>]*>([^<]*)</word>" (.toString out "UTF-8")))))

(defn rendered-text
  "rendered-words joined by single spaces."
  [d]
  (str/join " " (rendered-words d)))
