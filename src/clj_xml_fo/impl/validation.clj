(ns clj-xml-fo.impl.validation
  "Derives a malli registry for validation from the sitoa-generated one.

  The generated registry is shaped for sitoa's serde, which walks schema forms
  itself and never asks malli for a validator. Handed to m/validator as is, it
  fails or disagrees with the data sitoa reads and writes:

  1. A [:ref ...] directly under a sequence expression (:alt :cat :? :* :+
     :repeat) makes malli 0.20 throw ::m/potentially-recursive-seqex. Refs to
     non-regex schemas are wrapped as [:schema [:ref ...]] (one item); refs to
     regex schemas are inlined.
  2. sitoa reads an :alt outside a sequence expression as a choice over the
     whole value; malli reads it as a one-item sequence. It becomes :or.
  3. Mixed-content elements put their body under a required :xml/value even
     though an empty element (<fo:block/>) is legal and sitoa parses it without
     one. :xml/value becomes optional when its schema accepts empty content.
  4. A mixed-content :xml/value must be a vector of children; see child-list?.

  On top of those fixes, every element is registered once under
  :clj-xml-fo.element/<tag>, and every choice between elements becomes a
  [:multi {:dispatch first}] over those keys. The generator inlines the same
  element tuple at every use (they are identical to the global declarations),
  and malli reports every branch of a failed :or, so this turns pages of
  errors into the errors of the one element the data names, and shrinks the
  registry malli has to compile.")

(def element-ns "clj-xml-fo.element")

(defn element-key
  "Registry key of the validation schema for the FO element tag."
  [tag]
  (keyword element-ns (name tag)))

(def ^:private regex-ops #{:alt :cat :? :* :+ :repeat})

(defn- split
  "[op props children] of a schema form; props is nil when absent."
  [form]
  (let [[op & more] form]
    (if (map? (first more))
      [op (first more) (vec (rest more))]
      [op nil (vec more)])))

(defn- join [op props children]
  (into (cond-> [op] props (conj props)) children))

(defn- regex-form? [form]
  (and (vector? form) (contains? regex-ops (first form))))

(defn- element-tag
  "The tag of a sitoa element tuple [:tuple [:enum tag] content], else nil."
  [form]
  (when (and (vector? form) (= :tuple (first form)))
    (let [[_ _ [e :as children]] (split form)]
      (when (and (= 2 (count children)) (vector? e) (= :enum (first e)))
        (let [[_ _ values] (split e)]
          (when (= 1 (count values))
            (first values)))))))

(defn tag-of
  "Dispatch for element choices: the tag of [tag content], nil for anything
  else, which then fails validation instead of throwing."
  [x]
  (when (vector? x) (first x)))

(defn- child-list?
  "sitoa's hiccup unparser reads an :xml/value headed by a keyword as one
  whole element and puts its attributes on the enclosing element, dropping
  the tag. sitoa's parser never produces that shape, so refuse it."
  [v]
  (not (and (vector? v) (keyword? (first v)))))

(def ^:private mixed-content
  [:and :xml/hiccup
   [:fn {:error/message "should be a vector of children, e.g. [\"text\" [:inline ...]], not a single element"}
    child-list?]])

(defn- multi [tags]
  (into [:multi {:dispatch tag-of}]
        (map (fn [tag] [tag [:ref (element-key tag)]]))
        tags))

(defn registry
  "Validation registry for a sitoa registry and top type (the :multi of global
  elements). Contains every transformed registry entry plus one
  :clj-xml-fo.element/<tag> entry per global element.

  With :lenient? every attribute value schema becomes :string. fop.xsd has no
  grammar for property expressions (label-end(), proportional-column-width(1),
  rgb(...)) and is narrower than FOP elsewhere (lowercase hex colours,
  unitless 0), so lenient keeps element structure and attribute names closed
  while accepting any attribute value FOP might."
  [sitoa-registry top-type {:keys [lenient?]}]
  (let [choice-cache (atom {})
        choice-tags
        (fn choice-tags [form]
          ;; sorted set of element tags when form is purely a choice between
          ;; elements (through refs, :or and :alt), else nil
          (if-some [[_ v] (find @choice-cache form)]
            v
            (let [v (cond
                      (element-tag form) (sorted-set (element-tag form))

                      (and (vector? form) (= :ref (first form)))
                      (choice-tags (get sitoa-registry (second form)))

                      (and (vector? form) (#{:or :alt} (first form)))
                      (let [[_ _ children] (split form)
                            tags (map choice-tags children)]
                        (when (and (seq children) (every? some? tags))
                          (reduce into (sorted-set) tags))))]
              (swap! choice-cache assoc form v)
              v)))
        xf
        (fn xf [form ctx]
          ;; ctx is :seqex for a direct child of a sequence expression, else :value
          (if-not (vector? form)
            form
            (let [[op props children] (split form)
                  tag (element-tag form)
                  tags (when-not tag (choice-tags form))]
              (cond
                tag (cond->> [:ref (element-key tag)]
                      (= ctx :seqex) (vector :schema))

                (and tags (#{:or :alt :ref} op)) (multi tags)

                (= op :ref)
                (if (= ctx :seqex)
                  (let [target (get sitoa-registry (first children))]
                    (if (regex-form? target)
                      (xf target :seqex)
                      [:schema form]))
                  form)

                (and (= op :alt) (= ctx :value)) (join :or props (map #(xf % :value) children))

                (regex-ops op) (join op props (map #(xf % :seqex) children))

                (= op :map)
                (join :map props
                      (map (fn [entry]
                             (let [[k & more] entry
                                   [entry-props sch] (if (= 2 (count more)) more [nil (first more)])
                                   empty-ok? (or (= :xml/hiccup sch)
                                                 (and (vector? sch) (#{:* :?} (first sch))))
                                   entry-props (cond-> entry-props
                                                 (and (= :xml/value k) empty-ok?) (assoc :optional true))]
                               (cond-> [k]
                                 entry-props (conj entry-props)
                                 true (conj (cond
                                              (and lenient? (:xml/attr entry-props)) :string
                                              (and (= :xml/value k) (= :xml/hiccup sch)) mixed-content
                                              :else (xf sch :value))))))
                           children))

                (#{:enum :re := :fn} op) form

                :else (join op props (map #(xf % :value) children))))))
        elements (into {}
                       (map (fn [[tag arm]]
                              ;; transform the content, never the arm itself,
                              ;; or the element would refer to itself
                              (let [[op props [e content]] (split arm)]
                                [(element-key tag) (join op props [e (xf content :value)])])))
                       (drop 2 top-type))]
    (merge (update-vals sitoa-registry #(xf % :value)) elements)))
