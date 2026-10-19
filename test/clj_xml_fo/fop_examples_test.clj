(ns clj-xml-fo.fop-examples-test
  "Apache FOP's own example documents, read into data with sitoa's parser."
  (:require [clj-xml-fo.core :as fo]
            [clj-xml-fo.schema :as fo-schema]
            [clojure.java.io :as io]
            [clojure.test :refer [deftest is testing]]
            [dunnage.sitoa.parser :as parser])
  (:import (java.io ByteArrayOutputStream StringReader)
           (javax.xml.parsers SAXParserFactory)
           (org.apache.fop.apps FopFactory)
           (org.xml.sax InputSource)))

(def examples ["blockcontainer" "border" "character" "link" "list" "normal" "simple" "table"])

(def ^:private parse (delay (parser/xml-parser (fo-schema/make-schema))))

(defn- read-fo [r]
  (@parse (parser/make-stream-reader {} r)))

(defn- example [n]
  (with-open [r (io/reader (io/resource (str "fop-examples/" n ".fo")))]
    (read-fo r)))

(def ^:private fop-factory
  (delay (FopFactory/newInstance (.toURI (io/file "test-resources/fop-examples/")))))

(def ^:private area-tree "application/X-fop-areatree")

(defn- area-tree-of-file
  "FOP's area tree for the .fo file itself, the reference: every page, area
  and word with its position."
  [n]
  (let [out (ByteArrayOutputStream.)
        fop (.newFop ^FopFactory @fop-factory area-tree out)
        reader (.getXMLReader (.newSAXParser (doto (SAXParserFactory/newInstance)
                                               (.setNamespaceAware true))))]
    (.setContentHandler reader (.getDefaultHandler fop))
    (.parse reader (InputSource. (str (io/resource (str "fop-examples/" n ".fo")))))
    (.toString out "UTF-8")))

(deftest examples-validate
  (doseq [n examples]
    (testing n
      (is (fo/valid? (example n) {:lenient? true})))))

(deftest examples-round-trip-through-encode
  (doseq [n examples]
    (testing n
      (let [d (example n)]
        (is (= d (with-open [r (StringReader. (fo/xml-string d))]
                   (read-fo r))))))))

(defn- area-tree-of-data [d]
  (let [out (ByteArrayOutputStream.)]
    (fo/render! d out {:mime area-tree :fop-factory @fop-factory})
    (.toString out "UTF-8")))

(deftest examples-lay-out-like-the-original-files
  ;; list.fo has whitespace-only inlines, which sitoa's parser drops, so the
  ;; data it reads lays out a little differently; it is checked above.
  (doseq [n (remove #{"list"} examples)]
    (testing n
      (is (= (area-tree-of-file n)
             (area-tree-of-data (example n)))))))
