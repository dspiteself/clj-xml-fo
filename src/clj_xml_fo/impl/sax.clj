(ns clj-xml-fo.impl.sax
  "An XMLStreamWriter that forwards to a SAX ContentHandler.

  sitoa's unparser writes StAX events with bare local names. Apache FOP and
  javax.xml.transform consume SAX, and FOP only recognises elements in the
  XSL-FO namespace. This bridge resolves unprefixed element names against a
  default namespace (XSL-FO unless told otherwise), so sitoa output reaches FOP
  as fo: elements with no intermediate serialization.

  xmlns and xmlns:p attributes (the way hiccup content declares namespaces) are
  turned into SAX prefix mappings rather than attributes, so foreign content
  such as SVG inside fo:instream-foreign-object lands in its own namespace."
  (:import (java.util ArrayDeque)
           (javax.xml XMLConstants)
           (javax.xml.namespace NamespaceContext)
           (javax.xml.stream XMLStreamException XMLStreamWriter)
           (org.xml.sax ContentHandler)
           (org.xml.sax.ext LexicalHandler)
           (org.xml.sax.helpers AttributesImpl)))

(set! *warn-on-reflection* true)

(def fo-ns "http://www.w3.org/1999/XSL/Format")

(defn- split-qname [^String n]
  (let [i (.indexOf n ":")]
    (if (neg? i) [nil n] [(subs n 0 i) (subs n (inc i))])))

(defn- ns-decl
  "[prefix uri] when attribute name n declares a namespace, else nil."
  [^String n v]
  (cond
    (= n "xmlns") ["" v]
    (.startsWith n "xmlns:") [(subs n 6) v]))

(defn- bind
  "Bind prefix (\"\" for the default namespace) to uri in a scope. Rebinding
  the default namespace retires the implicit prefix used for bare names."
  [scope prefix uri]
  (cond-> (assoc-in scope [:ns prefix] uri)
    (= "" prefix) (assoc :implicit-prefix nil)))

(defn- lookup ^String [scope prefix]
  (or (get-in scope [:ns prefix])
      (throw (XMLStreamException. (str "Undeclared namespace prefix: " prefix)))))

(defn- prefix-of
  "A prefix bound to uri in scope, \"\" when only the default namespace is."
  [scope uri]
  (let [ps (keep (fn [[p u]] (when (= u uri) p)) (:ns scope))]
    (or (first (remove #{""} ps)) (first ps))))

(defn- namespace-context [scope]
  (reify NamespaceContext
    (getNamespaceURI [_ prefix] (get-in scope [:ns prefix] XMLConstants/NULL_NS_URI))
    (getPrefix [_ uri] (prefix-of scope uri))
    (getPrefixes [_ uri]
      (.iterator ^Iterable (into [] (keep (fn [[p u]] (when (= u uri) p))) (:ns scope))))))

(defn stream-writer
  "Returns an XMLStreamWriter that emits SAX events into handler.

  Options:
    :default-ns      namespace for unprefixed element names (default XSL-FO)
    :default-prefix  prefix declared for it at document start and used in
                     qualified names, \"fo\" by default; nil declares it as the
                     default namespace instead

  writeStartDocument / writeEndDocument map to startDocument / endDocument.
  Closing the writer does not close anything downstream."
  (^XMLStreamWriter [^ContentHandler handler]
   (stream-writer handler {}))
  (^XMLStreamWriter [^ContentHandler handler {:keys [default-ns default-prefix]
                                              :or   {default-ns     fo-ns
                                                     default-prefix "fo"}}]
   (let [root-decl [(or default-prefix "") default-ns]
         root-scope {:ns              (assoc {"" default-ns "xml" XMLConstants/XML_NS_URI}
                                             (first root-decl) default-ns)
                     :implicit-prefix default-prefix}
         ;; open elements: {:uri :local :qname :decls :scope}
         frames (ArrayDeque.)
         ;; start tag waiting for its attributes; SAX needs them all at once
         pending (volatile! nil)
         scope (fn [] (if (.isEmpty frames) root-scope (:scope (.peek frames))))
         close-element!
         (fn []
           (when (.isEmpty frames)
             (throw (XMLStreamException. "writeEndElement with no open element")))
           (let [{:keys [uri local qname decls]} (.pop frames)]
             (.endElement handler uri local qname)
             (doseq [[p] (rseq decls)]
               (.endPrefixMapping handler p))))
         flush!
         (fn []
           (when-some [{:keys [prefix local uri attrs decls empty?]} @pending]
             (vreset! pending nil)
             (let [decls (into decls (keep (fn [[n v]] (ns-decl n v))) attrs)
                   ;; namespaced writeStartElement/writeAttribute calls may
                   ;; name a prefix that is not bound yet
                   decls (cond-> decls (and uri prefix) (conj [prefix uri]))
                   decls (into decls
                               (keep (fn [[_ _ auri aprefix]]
                                       (when (and auri aprefix) [aprefix auri])))
                               attrs)
                   s (reduce (fn [s [p u]] (bind s p u)) (scope) decls)
                   ;; an element named by URI alone reuses a bound prefix, or
                   ;; becomes the default namespace for its subtree
                   [prefix decls s] (if (and uri (nil? prefix))
                                      (if-some [p (prefix-of s uri)]
                                        [(not-empty p) decls s]
                                        [nil (conj decls ["" uri]) (bind s "" uri)])
                                      [prefix decls s])
                   decls (into [] (distinct) decls)
                   el-uri (cond uri uri
                                prefix (lookup s prefix)
                                :else (get-in s [:ns ""] ""))
                   qname (cond
                           prefix (str prefix ":" local)
                           (and (:implicit-prefix s) (= el-uri (get-in s [:ns ""])))
                           (str (:implicit-prefix s) ":" local)
                           :else local)
                   sax-attrs (AttributesImpl.)]
               (doseq [[n v auri aprefix] attrs
                       :when (not (ns-decl n v))]
                 (let [[p l] (if (or auri aprefix) [aprefix n] (split-qname n))
                       u (cond auri auri p (lookup s p) :else "")
                       ;; attributes never take the default namespace
                       p (or p (when (seq u) (not-empty (prefix-of s u))))]
                   (.addAttribute sax-attrs u l (if p (str p ":" l) l) "CDATA" (str v))))
               (doseq [[p u] decls]
                 (.startPrefixMapping handler p u))
               (.startElement handler el-uri local qname sax-attrs)
               (.push frames {:uri el-uri :local local :qname qname :decls decls :scope s})
               (when empty?
                 (close-element!)))))
         start! (fn [prefix local uri empty?]
                  (flush!)
                  (let [[p l] (if (or prefix uri) [prefix local] (split-qname local))]
                    (vreset! pending {:prefix p :local l :uri uri :empty? empty?
                                      :attrs [] :decls []})))
         attr! (fn [n v uri prefix]
                 (when-not @pending
                   (throw (XMLStreamException. (str "Attribute " n " written outside a start tag"))))
                 (vswap! pending update :attrs conj [n v uri prefix]))
         decl! (fn [prefix uri]
                 (when-not @pending
                   (throw (XMLStreamException. "Namespace written outside a start tag")))
                 (vswap! pending update :decls conj [prefix uri]))
         characters! (fn [^chars cs start len]
                       (flush!)
                       (.characters handler cs (int start) (int len)))]
     (reify XMLStreamWriter
       (writeStartDocument [_]
         (.startDocument handler)
         (.startPrefixMapping handler (first root-decl) (second root-decl)))
       (writeStartDocument [this _version] (.writeStartDocument this))
       (writeStartDocument [this _encoding _version] (.writeStartDocument this))
       (writeEndDocument [_]
         (flush!)
         (while (not (.isEmpty frames))
           (close-element!))
         (.endPrefixMapping handler (first root-decl))
         (.endDocument handler))

       (writeStartElement [_ local] (start! nil local nil false))
       (writeStartElement [_ uri local] (start! nil local uri false))
       (writeStartElement [_ prefix local uri] (start! (not-empty prefix) local uri false))
       (writeEmptyElement [_ local] (start! nil local nil true))
       (writeEmptyElement [_ uri local] (start! nil local uri true))
       (writeEmptyElement [_ prefix local uri] (start! (not-empty prefix) local uri true))
       (writeEndElement [_]
         (flush!)
         (close-element!))

       (writeAttribute [_ n v] (attr! n v nil nil))
       (writeAttribute [_ uri local v] (attr! local v uri nil))
       (writeAttribute [_ prefix uri local v] (attr! local v uri prefix))
       (writeNamespace [_ prefix uri]
         (decl! (if (or (nil? prefix) (= "xmlns" prefix)) "" prefix) uri))
       (writeDefaultNamespace [_ uri] (decl! "" uri))

       (writeCharacters [_ s]
         (let [s ^String s]
           (characters! (.toCharArray s) 0 (.length s))))
       (writeCharacters [_ cs start len] (characters! cs start len))
       (writeCData [_ s]
         (let [s ^String s]
           (characters! (.toCharArray s) 0 (.length s))))
       (writeComment [_ s]
         (flush!)
         (when (instance? LexicalHandler handler)
           (let [s ^String s]
             (.comment ^LexicalHandler handler (.toCharArray s) 0 (.length s)))))
       (writeProcessingInstruction [_ target]
         (flush!)
         (.processingInstruction handler target ""))
       (writeProcessingInstruction [_ target data]
         (flush!)
         (.processingInstruction handler target data))
       (writeDTD [_ _dtd])
       (writeEntityRef [_ n]
         (throw (UnsupportedOperationException. (str "Entity references are not supported: " n))))

       (getPrefix [_ uri] (prefix-of (scope) uri))
       (getNamespaceContext [_] (namespace-context (scope)))
       (setPrefix [_ _prefix _uri]
         (throw (UnsupportedOperationException. "setPrefix; declare namespaces with writeNamespace or xmlns attributes")))
       (setDefaultNamespace [_ _uri]
         (throw (UnsupportedOperationException. "setDefaultNamespace; use writeDefaultNamespace or an xmlns attribute")))
       (setNamespaceContext [_ _ctx]
         (throw (UnsupportedOperationException. "setNamespaceContext")))
       (getProperty [_ n]
         (throw (IllegalArgumentException. (str "Unsupported property: " n))))
       (flush [_])
       (close [_])))))
