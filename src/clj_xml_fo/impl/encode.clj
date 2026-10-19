(ns clj-xml-fo.impl.encode
  "Writes FO data to an XMLStreamWriter, streaming where the data streams.

  A fully materialized element, one built only from vectors, maps and scalars,
  is handed to sitoa's unparser in a single call. An element whose content
  holds a stream is opened here instead: its attributes and children are
  written in schema order, and each stream is consumed with reduce, one item at
  a time, each item going back through the same choice.

  sitoa's sequence unparsers index into their data with count and nth, which
  would realize a stream whole (and walk a lazy seq quadratically), so streams
  never reach it.

  A stream is any sequential collection that is not a vector (a lazy seq, a
  list, an eduction) and anything else that is IReduceInit but not a vector,
  map or string. Inside element or mixed content a stream is spliced: its
  items take its place, as in hiccup."
  (:require [malli.core :as m]
            [malli.error :as me])
  (:import (clojure.lang IReduceInit)
           (javax.xml.stream XMLStreamWriter)))

(set! *warn-on-reflection* true)

(defn stream? [x]
  (and (not (vector? x))
       (not (map? x))
       (not (string? x))
       (or (sequential? x) (instance? IReduceInit x))))

(defn static?
  "True when x holds no stream at any depth. Stops at the first stream, so it
  never realizes one."
  [x]
  (cond
    (stream? x) false
    (vector? x) (every? static? x)
    (map? x) (every? static? (vals x))
    :else true))

;; ---------------------------------------------------------------------------
;; Element structure, read from the validation schema
;; ---------------------------------------------------------------------------

(defn- deref* [s]
  (case (m/type s)
    (:ref :schema ::m/schema :merge) (recur (m/deref s))
    s))

(defn- value-kind [s]
  (let [s (deref* s)]
    (case (m/type s)
      :xml/hiccup :hiccup
      ;; [:and base refinement...]: the base type says how it is written
      :and (value-kind (first (m/children s)))
      (:string :enum :re := :int :double :decimal :boolean) :text
      :elements)))

(defn- element-refs
  "Tags of the elements a validation schema form refers to, without following
  refs: the elements allowed directly in that position."
  [form]
  (into #{}
        (keep (fn [x]
                (when (and (keyword? x) (= "clj-xml-fo.element" (namespace x)))
                  (keyword (name x)))))
        (tree-seq coll? seq form)))

(defn element-info
  "What the encoder needs to open an element by hand, from its schema:

    :attrs     [[key schema] ...] in schema order
    :children  [[key many?] ...] child elements keyed by tag, in schema order
    :required  keys the element must have
    :value     :elements, :hiccup (mixed content) or :text when the element
               takes :xml/value, else nil
    :allowed   for :elements, the tags allowed in it
    :foreign?  for :elements, whether non-FO hiccup is allowed in it"
  [element-schema]
  (let [tuple (deref* element-schema)
        content (deref* (second (m/children tuple)))]
    (when-not (= :map (m/type content))
      (throw (ex-info "Element content is not a map schema" {:form (m/form tuple)})))
    (let [entries (m/children content)
          value-schema (some (fn [[k _ s]] (when (= :xml/value k) s)) entries)
          value-form (some-> value-schema m/form)]
      {:attrs (into []
                    (keep (fn [[k props s]] (when (:xml/attr props) [k s])))
                    entries)
       :children (into []
                       (keep (fn [[k props s]]
                               (when-not (or (:xml/attr props) (= :xml/value k))
                                 [k (= :sequential (m/type (deref* s)))])))
                       entries)
       :required (into #{} (keep (fn [[k props]] (when-not (:optional props) k))) entries)
       :value (some-> value-schema value-kind)
       :allowed (element-refs value-form)
       :foreign? (boolean (some #{:xml/hiccup} (tree-seq coll? seq value-form)))})))

;; ---------------------------------------------------------------------------
;; Writing
;; ---------------------------------------------------------------------------

(defn- invalid! [message data]
  (throw (ex-info message (merge {:type :clj-xml-fo.core/invalid} data))))

(defn- write-hiccup!
  "Hiccup [tag attrs? & children], as sitoa writes it, except that streams
  among the children are spliced."
  [^XMLStreamWriter w x]
  (cond
    (nil? x) nil
    (string? x) (.writeCharacters w ^String x)
    (vector? x) (let [[tag & more] x
                      [attrs children] (if (map? (first more)) [(first more) (rest more)] [nil more])]
                  (.writeStartElement w (name tag))
                  (doseq [[k v] attrs]
                    (.writeAttribute w (name k) (str v)))
                  (run! #(write-hiccup! w %) children)
                  (.writeEndElement w))
    (stream? x) (run! #(write-hiccup! w %) x)
    :else (.writeCharacters w (str x))))

(defn- write-mixed!
  "An :xml/hiccup body, mirroring sitoa's hiccup unparser: a vector headed by
  a keyword is a whole element form whose attributes land on the already open
  element; any other sequence is the children."
  [^XMLStreamWriter w v]
  (cond
    (and (vector? v) (keyword? (first v)))
    (let [[_ & more] v
          [attrs children] (if (map? (first more)) [(first more) (rest more)] [nil more])]
      (doseq [[k a] attrs]
        (.writeAttribute w (name k) (str a)))
      (run! #(write-hiccup! w %) children))

    (or (sequential? v) (stream? v)) (run! #(write-hiccup! w %) v)

    (some? v) (.writeCharacters w (str v))))

(declare write-element!)

(defn- write-items!
  "Element content: FO elements as [tag content], and foreign hiccup where the
  schema allows it. Unchecked, text is written as is, as sitoa would."
  [ctx ^XMLStreamWriter w path parent {:keys [allowed foreign?] :as info} items]
  (let [validating? (some? (:validate ctx))]
    (reduce (fn [i item]
              (let [path (conj path i)
                    tag (when (vector? item) (first item))]
                (cond
                  (nil? item) nil
                  (stream? item) (write-items! ctx w path parent info item)

                  ((:element? ctx) tag)
                  (cond
                    (not (and (= 2 (count item)) (map? (second item))))
                    (invalid! (str "FO element " tag " must be [tag content-map] here;"
                                   " hiccup [tag attrs & children] is only for mixed content (:xml/value of block, inline, ...)")
                              {:path path :tag tag})

                    (and validating? (not (contains? allowed tag)))
                    (invalid! (str tag " is not allowed in " parent)
                              {:path path :tag parent :errors [(str "should be one of " (sort allowed))]})

                    :else (write-element! ctx w (conj path 1) item))

                  (and (vector? item) (or foreign? (not validating?))) (write-hiccup! w item)

                  validating?
                  (invalid! (str (if tag (str "Unknown element " tag) "Text") " is not allowed in " parent)
                            {:path path :tag parent :errors [(str "should be one of " (sort allowed))]})

                  (string? item) (.writeCharacters w ^String item)
                  (vector? item) (write-hiccup! w item)
                  :else (.writeCharacters w (str item))))
              (inc i))
            0
            items))
  nil)

(defn- check-container!
  "Validation for an element opened by hand: its attribute values and its
  keys. Children are validated as they are written."
  [{:keys [attrs children required value]} tag content path]
  (let [attr-schemas (into {} attrs)
        child-keys (into #{} (map first) children)
        missing (into (sorted-set) (remove #(contains? content %)) required)]
    (when (seq missing)
      (invalid! (str "XSL-FO element " tag " is missing " (vec missing))
                {:path path :tag tag :errors (zipmap missing (repeat ["missing required key"]))}))
    (doseq [[k v] content]
      (cond
        (contains? attr-schemas k)
        (let [s (get attr-schemas k)]
          (when-not (m/validate s v)
            (invalid! (str "Invalid XSL-FO attribute " k " on " tag)
                      {:path path :tag tag :errors {k (me/humanize (m/explain s v))}})))

        (contains? child-keys k) nil
        (and value (= :xml/value k)) nil
        :else (invalid! (str "Unknown key " k " on XSL-FO element " tag)
                        {:path path :tag tag :errors {k ["disallowed key"]}})))))

(defn write-element!
  "Write [tag content]. ctx:

    :element-writer  sitoa value-mode unparser for any element, (fn [el w])
    :element?        predicate on FO element tags
    :element-info    tag -> element-info
    :validate        nil, or (fn [tag el path]) that throws on invalid data

  path is the get-in path of content within the document, for errors."
  [ctx ^XMLStreamWriter w path [tag content :as el]]
  (if (static? content)
    (do (when-some [validate (:validate ctx)]
          (validate tag el path))
        ((:element-writer ctx) el w))
    (let [{:keys [attrs children value] :as info} ((:element-info ctx) tag)]
      (when (:validate ctx)
        (check-container! info tag content path))
      (.writeStartElement w (name tag))
      (doseq [[k _] attrs]
        (when-some [v (get content k)]
          (.writeAttribute w (name k) (str v))))
      (doseq [[k many?] children]
        (when-some [v (get content k)]
          (if many?
            (if (map? v)
              (invalid! (str k " takes a sequence of elements, not a single map")
                        {:path (conj path k) :tag k})
              (reduce (fn [i child]
                        (write-element! ctx w (conj path k i) [k child])
                        (inc i))
                      0
                      v))
            (write-element! ctx w (conj path k) [k v]))))
      (when-some [v (:xml/value content)]
        (case value
          :elements (write-items! ctx w (conj path :xml/value) tag info v)
          :hiccup (write-mixed! w v)
          :text (.writeCharacters w (str v))
          nil))
      (.writeEndElement w))))
