(ns clj-xml-fo.core
  "XSL-FO as Clojure data: validate it, and encode it with sitoa's unparser
  straight into Apache FOP.

  Data follows sitoa's XML binding. An element is [tag content], where content
  is a map of attributes, child elements keyed by tag, and (for elements with
  ordered or mixed content) :xml/value:

    [:root
     {:layout-master-set
      {:xml/value [[:simple-page-master {:master-name \"A4\"
                                          :page-width \"210mm\" :page-height \"297mm\"
                                          :region-body {:margin \"2cm\"}}]]}
      :page-sequence
      [{:master-reference \"A4\"
        :flow {:flow-name \"xsl-region-body\"
               :xml/value [[:block {:font-size \"14pt\"
                                    :xml/value [\"Hello, \" [:inline {:font-weight \"bold\"} \"world\"]]}]]}}]}]

  Mixed content (the :xml/value of block, inline, ...) is hiccup, which the
  schema does not look inside. See the README for the full picture.

  The schema is generated from Apache FOP's fop.xsd by sitoa's bootstrap; see
  bootstrap/clj_xml_fo/bootstrap.clj."
  (:require
   ;; first: fails fast when the malli on the classpath is older than 0.20.2
   [clj-xml-fo.impl.malli-version]
   [clj-xml-fo.impl.encode :as encode]
   [clj-xml-fo.impl.sax :as sax]
   [clj-xml-fo.impl.validation :as validation]
   [clj-xml-fo.schema :as fo-schema]
   [clojure.java.io :as io]
   [dunnage.sitoa.unparser :as unparser]
   [dunnage.sitoa.xml-primitives :as xml-primitives]
   [malli.core :as m]
   [malli.error :as me])
  (:import (java.io OutputStream StringWriter Writer)
           (javax.xml.transform OutputKeys TransformerFactory)
           (javax.xml.transform.sax SAXTransformerFactory)
           (javax.xml.transform.stream StreamResult)
           (org.apache.fop.apps FOUserAgent FopFactory FormattingResults PageSequenceResults)
           (org.apache.xmlgraphics.util MimeConstants)
           (org.xml.sax ContentHandler)))

(set! *warn-on-reflection* true)

(def fo-ns
  "The XSL-FO namespace URI."
  sax/fo-ns)

(def element-tags
  "Tags of every global XSL-FO element in the schema."
  (into (sorted-set) (map first) (drop 2 fo-schema/top-type)))

;; ---------------------------------------------------------------------------
;; Validation
;; ---------------------------------------------------------------------------

(def ^:private options
  (let [build (fn [opts]
                {:registry (merge (:registry xml-primitives/external-registry)
                                  (validation/registry fo-schema/registry fo-schema/top-type opts))})
        strict (delay (build {}))
        lenient (delay (build {:lenient? true}))]
    (fn [{:keys [lenient?]}]
      (if lenient? @lenient @strict))))

(defn registry
  "The malli registry behind schema, for composing FO elements into your own
  schemas: every generated type, malli's defaults, and one
  :clj-xml-fo.element/<tag> entry per element, e.g.

    (m/schema [:vector :clj-xml-fo.element/block] {:registry (fo/registry)})

  Takes the same options as schema."
  ([] (registry {}))
  ([opts] (:registry (options opts))))

(def ^:private compiled (atom {}))

(defn- compiled-for [tag opts]
  (let [k [tag (boolean (:lenient? opts))]]
    (or (get @compiled k)
        (let [form (if (= ::any tag)
                     (into [:multi {:dispatch validation/tag-of}]
                           (map (fn [t] [t (validation/element-key t)]))
                           element-tags)
                     (if (contains? element-tags tag)
                       (validation/element-key tag)
                       (throw (ex-info (str "Unknown XSL-FO element: " tag)
                                       {:type ::unknown-element :tag tag}))))
              s (m/schema form (options opts))
              c {:schema    s
                 :validator (m/validator s)
                 :explainer (m/explainer s)}]
          (swap! compiled assoc k c)
          c))))

(defn schema
  "Malli schema for data of the shape [tag content]: for the element tag, or
  with no tag for any FO element, chosen by the tag the data carries.

  Strict by default: attribute values must match fop.xsd. fop.xsd has no
  grammar for property expressions such as label-end() or
  proportional-column-width(1), and is narrower than FOP elsewhere (lowercase
  hex colours, unitless 0, lowercase language codes). With {:lenient? true}
  attribute values need only be strings; element structure and attribute
  names are still checked."
  ([] (schema ::any {}))
  ([tag] (schema tag {}))
  ([tag opts] (:schema (compiled-for tag opts))))

(defn valid?
  "True when x is valid FO data for the element its tag names, e.g. a whole
  [:root ...] document or a [:table ...] built on its own. Options as for
  schema.

  Mixed content (:xml/value of block, inline, ...) is only checked to be a
  vector. Do not call this on a document holding streams: malli would consume
  them. Pass :validate? true to encode! / render! instead."
  ([x] (valid? x {}))
  ([x opts] ((:validator (compiled-for ::any opts)) x)))

(defn explain
  "Malli explanation of why x is invalid, else nil. Options as for schema."
  ([x] (explain x {}))
  ([x opts] ((:explainer (compiled-for ::any opts)) x)))

(defn- invalid-ex [explanation data]
  (ex-info "Invalid XSL-FO"
           (merge {:type        ::invalid
                   :errors      (me/humanize explanation)
                   :explanation explanation}
                  data)))

(defn validate
  "Returns x when valid, else throws ex-info with :type ::invalid, humanized
  :errors and the malli :explanation. Options as for schema."
  ([x] (validate x {}))
  ([x opts]
   (if-some [explanation (explain x opts)]
     (throw (invalid-ex explanation {:tag (when (vector? x) (first x))}))
     x)))

;; ---------------------------------------------------------------------------
;; Encoding
;; ---------------------------------------------------------------------------

(def ^:private element-writer
  ;; One sitoa unparser for every element: the top type is a :multi over the
  ;; global elements, and its value-mode (2-arity) unparser writes whichever
  ;; element the data names. Called with [tag content] and a writer.
  (delay (unparser/-xml-unparser- (fo-schema/make-schema) false)))

(def ^:private element-info
  (let [cache (atom {})]
    (fn [tag opts]
      (let [k [tag (boolean (:lenient? opts))]]
        (or (get @cache k)
            (let [info (encode/element-info (schema tag opts))]
              (swap! cache assoc k info)
              info))))))

(defn- checker [opts]
  (fn [tag el path]
    (when-some [explanation (explain el opts)]
      (throw (invalid-ex explanation {:tag tag :path path})))))

(defn- precheck
  "With :validate?, check a fully materialized doc whole before anything is
  opened or written, and return opts with validation done. A doc holding
  streams keeps :validate? and is checked as it is encoded."
  [doc {:keys [validate?] :as opts}]
  (if (and validate? (encode/static? doc))
    (do ((checker opts) (when (vector? doc) (first doc)) doc [1])
        (assoc opts :validate? false))
    opts))

(defn encode!
  "Write doc as SAX events into handler, startDocument through endDocument.
  Elements land in the XSL-FO namespace (prefix fo). doc is normally a whole
  [:root content] document; any single FO element works too.

  Fully materialized data is written by sitoa's schema-driven unparser in one
  pass. Content may also stream: wherever a document takes a sequence of
  elements (root's :page-sequence, the :xml/value of flow, table-body,
  table-cell, list-block, ..., or mixed content) you can pass a lazy seq, an
  eduction or any IReduceInit instead of a vector. It is consumed with reduce,
  once, and each item is encoded and handed downstream before the next is
  produced. An eduction over a reducible source (a JDBC plan, a file's lines)
  keeps memory flat; a lazy seq held by the document is retained as it is
  realized. Streams may also sit among other items, where they are spliced.

  sitoa's unparser writes only what the schema names: a key it does not know,
  such as a misspelt attribute, is silently left out. Options:

    :validate?  check the data while encoding and throw ex-info (:type
                ::invalid, :path, :errors) before writing anything invalid.
                Materialized subtrees are validated whole. An element opened
                around a stream has its attributes and keys checked, and every
                streamed item is validated as it arrives and must be an
                element its parent allows; the order and count of streamed
                items are not checked. Off by default, since FOP validates
                structure itself.
    :lenient?   with :validate?, accept any string attribute value (see
                schema); strict fop.xsd rejects common FO such as
                end-indent=\"label-end()\"."
  ([doc handler] (encode! doc handler {}))
  ([doc ^ContentHandler handler opts]
   (let [{:keys [validate?] :as opts} (precheck doc opts)
         w (sax/stream-writer handler)
         ctx {:element-writer @element-writer
              :element?       element-tags
              :element-info   #(element-info % opts)
              :validate       (when validate? (checker opts))}]
     (.writeStartDocument w)
     (encode/write-element! ctx w [1] doc)
     (.writeEndDocument w)
     nil)))

(defn write-xml!
  "Serialize doc as XSL-FO XML to out: a Writer or OutputStream (left open),
  or anything clojure.java.io/output-stream accepts (opened and closed here).
  Takes encode! options plus :indent? (default false; indenting can add
  whitespace inside mixed content)."
  ([doc out] (write-xml! doc out {}))
  ([doc out opts]
   (let [{:keys [indent?] :as opts} (precheck doc opts)]
     (if (or (instance? Writer out) (instance? OutputStream out))
       (let [th (.newTransformerHandler ^SAXTransformerFactory (TransformerFactory/newDefaultInstance))]
         (doto (.getTransformer th)
           (.setOutputProperty OutputKeys/ENCODING "UTF-8")
           (.setOutputProperty OutputKeys/INDENT (if indent? "yes" "no")))
         (.setResult th (if (instance? Writer out)
                          (StreamResult. ^Writer out)
                          (StreamResult. ^OutputStream out)))
         (encode! doc th opts))
       (with-open [os (io/output-stream out)]
         (write-xml! doc os opts))))))

(defn xml-string
  "doc as an XSL-FO XML string. Takes write-xml! options."
  ([doc] (xml-string doc {}))
  ([doc opts]
   (let [sw (StringWriter.)]
     (write-xml! doc sw opts)
     (str sw))))

;; ---------------------------------------------------------------------------
;; Apache FOP
;; ---------------------------------------------------------------------------

(def ^:private default-fop-factory
  (delay (FopFactory/newInstance (.toURI (io/file ".")))))

(defn- results [^FormattingResults r]
  (when r
    {:page-count     (.getPageCount r)
     :page-sequences (mapv (fn [^PageSequenceResults p]
                             {:id (.getID p) :page-count (.getPageCount p)})
                           (.getPageSequences r))}))

(defn render!
  "Render doc with Apache FOP to out: an OutputStream (left open), or anything
  clojure.java.io/output-stream accepts, such as a File or path (opened and
  closed here). The data goes from sitoa's unparser to FOP as SAX events; no
  XML text is produced on the way. Returns {:page-count n :page-sequences
  [{:id .. :page-count ..}]}.

  Takes encode! options (:validate?, streaming content) plus:

    :mime         output format, default \"application/pdf\"; any FOP
                  renderer works, e.g. \"text/plain\" or \"image/png\"
    :fop-factory  a FopFactory, e.g. from an fop.xconf; by default one shared
                  factory resolving relative URIs against the working directory
    :user-agent   an FOUserAgent, for per-render settings (metadata,
                  accessibility, ...); overrides :fop-factory

  FOP lays out each page-sequence once it has read all of it, so streaming
  bounds the Clojure side; to bound FOP's memory too, split long content over
  several page-sequences."
  ([doc out] (render! doc out {}))
  ([doc out opts]
   ;; before the Fop exists: FOP writes the PDF header as soon as it does
   (let [{:keys [mime fop-factory user-agent] :as opts} (precheck doc opts)]
     (if (instance? OutputStream out)
       (let [^FopFactory factory (or fop-factory @default-fop-factory)
             ^FOUserAgent ua (or user-agent (.newFOUserAgent factory))
             fop (.newFop ua ^String (or mime MimeConstants/MIME_PDF) ^OutputStream out)]
         (encode! doc (.getDefaultHandler fop) opts)
         (results (.getResults fop)))
       (with-open [os (io/output-stream out)]
         (render! doc os opts))))))
