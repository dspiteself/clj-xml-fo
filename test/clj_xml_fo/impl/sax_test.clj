(ns clj-xml-fo.impl.sax-test
  (:require [clj-xml-fo.impl.sax :as sax]
            [clojure.test :refer [deftest is]])
  (:import (javax.xml XMLConstants)
           (javax.xml.stream XMLStreamWriter)
           (org.xml.sax Attributes)
           (org.xml.sax.helpers DefaultHandler)))

(defn- events
  "SAX events from driving a bridge writer with f."
  ([f] (events {} f))
  ([opts f]
   (let [log (atom [])
         handler (proxy [DefaultHandler] []
                   (startPrefixMapping [p u] (swap! log conj [:ns p u]))
                   (endPrefixMapping [p] (swap! log conj [:end-ns p]))
                   (startElement [u l q ^Attributes as]
                     (swap! log conj (into [:start u l q]
                                           (map (fn [i] [(.getURI as i) (.getLocalName as i)
                                                         (.getQName as i) (.getValue as i)]))
                                           (range (.getLength as)))))
                   (endElement [u l q] (swap! log conj [:end u l q]))
                   (characters [cs start len] (swap! log conj [:text (String. ^chars cs (int start) (int len))])))
         w (sax/stream-writer handler opts)]
     (.writeStartDocument w)
     (f w)
     (.writeEndDocument w)
     @log)))

(deftest bare-names-land-in-the-fo-namespace
  (is (= [[:ns "fo" sax/fo-ns]
          [:start sax/fo-ns "block" "fo:block" ["" "font-size" "font-size" "12pt"]]
          [:text "hi"]
          [:end sax/fo-ns "block" "fo:block"]
          [:end-ns "fo"]]
         (events (fn [^XMLStreamWriter w]
                   (.writeStartElement w "block")
                   (.writeAttribute w "font-size" "12pt")
                   (.writeCharacters w "hi")
                   (.writeEndElement w))))))

(deftest xmlns-attributes-declare-namespaces
  (let [svg "http://www.w3.org/2000/svg"
        xlink "http://www.w3.org/1999/xlink"]
    (is (= [[:ns "fo" sax/fo-ns]
            [:ns "" svg]
            [:ns "xlink" xlink]
            [:start svg "svg" "svg"]
            [:start svg "image" "image" [xlink "href" "xlink:href" "a.png"]]
            [:end svg "image" "image"]
            [:end svg "svg" "svg"]
            [:end-ns "xlink"]
            [:end-ns ""]
            [:start sax/fo-ns "block" "fo:block"]
            [:end sax/fo-ns "block" "fo:block"]
            [:end-ns "fo"]]
           (events (fn [^XMLStreamWriter w]
                     (.writeStartElement w "svg")
                     (.writeAttribute w "xmlns" svg)
                     (.writeAttribute w "xmlns:xlink" xlink)
                     (.writeStartElement w "image")
                     (.writeAttribute w "xlink:href" "a.png")
                     (.writeEndElement w)
                     (.writeEndElement w)
                     (.writeStartElement w "block")
                     (.writeEndElement w)))))))

(deftest xml-prefix-is-predeclared
  (is (= [:start sax/fo-ns "block" "fo:block" [XMLConstants/XML_NS_URI "lang" "xml:lang" "en"]]
         (second (events (fn [^XMLStreamWriter w]
                           (.writeStartElement w "block")
                           (.writeAttribute w "xml:lang" "en")
                           (.writeEndElement w)))))))

(deftest namespaced-stax-calls
  (let [uri "urn:example"]
    (is (= [[:ns "fo" sax/fo-ns]
            [:ns "ex" uri]
            [:start uri "a" "ex:a" [uri "b" "ex:b" "1"]]
            [:end uri "a" "ex:a"]
            [:end-ns "ex"]
            [:end-ns "fo"]]
           (events (fn [^XMLStreamWriter w]
                     (.writeStartElement w "ex" "a" uri)
                     (.writeAttribute w "ex" uri "b" "1")
                     (.writeEndElement w)))))))

(deftest default-namespace-without-a-prefix
  (is (= [[:ns "" sax/fo-ns]
          [:start sax/fo-ns "root" "root"]
          [:end sax/fo-ns "root" "root"]
          [:end-ns ""]]
         (events {:default-prefix nil}
                 (fn [^XMLStreamWriter w]
                   (.writeEmptyElement w "root"))))))
