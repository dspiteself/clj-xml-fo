# clj-xml-fo

XSL-FO as Clojure data. Validate it with a [malli](https://github.com/metosin/malli)
schema generated from Apache FOP's own `fop.xsd`. Encode it with
[sitoa](https://github.com/dunnage/sitoa)'s schema-driven unparser straight
into [Apache FOP](https://xmlgraphics.apache.org/fop/), with no XML text in
between. Content can stream.

```clojure
(require '[clj-xml-fo.core :as fo])

(def doc
  [:root
   {:layout-master-set
    {:xml/value [[:simple-page-master {:master-name "A4"
                                       :page-width  "210mm"
                                       :page-height "297mm"
                                       :region-body {:margin "2cm"}}]]}
    :page-sequence
    [{:master-reference "A4"
      :flow {:flow-name "xsl-region-body"
             :xml/value [[:block {:font-size "14pt"
                                  :xml/value ["Hello, " [:inline {:font-weight "bold"} "world"] "!"]}]]}}]}])

(fo/valid? doc)                ;=> true
(fo/render! doc "hello.pdf")   ;=> {:page-count 1, :page-sequences [{:id "", :page-count 1}]}
(fo/xml-string doc)            ;=> "<?xml ...?><fo:root xmlns:fo=\"http://www.w3.org/1999/XSL/Format\">..."
```

## Installation

clj-xml-fo is a deps.edn library. Add it as a git dependency:

```clojure
{:deps {io.github.dspiteself/clj-xml-fo {:git/sha "a136cc49c69aa905bfad1ac970df34b45b96f5a6"}}}
```

The `io.github.dspiteself/clj-xml-fo` name tells tools.deps to fetch
https://github.com/dspiteself/clj-xml-fo.git. Pin the full sha of the commit
you want. This prints the latest one:

```bash
git ls-remote https://github.com/dspiteself/clj-xml-fo.git refs/heads/main
```

It brings in Apache FOP 2.11, malli and sitoa's `serde` and
`xml-primitives`. sitoa's XSD tooling (`bootstrapped-schema`, XSOM, JAXB) is
**not** on the runtime classpath. Only the `:bootstrap` alias uses it.

**malli 0.20.2 or newer is required**, for performance. The FO schema is large
and recursive through refs. malli 0.20.1 compiles recursive validators, and
0.20.2 fixes a startup-time regression and some `malli.error/humanize`
failures. deps.edn names 0.20.2. tools.deps uses the newest version any
dependency asks for, so a newer malli elsewhere in your tree is fine. A version
pinned at the top level of your own deps.edn always wins, however old, so
`clj-xml-fo.core` refuses to load with an older malli jar and names the version
it found. When malli comes from a git or local dependency, or from inside an
uberjar, there is no jar version to read, and the check is skipped.

You may get "Unable to compare versions for
io.github.dunnage.sitoa/xml-primitives". That happens when another library in
your tree names a sitoa module as a git dep. sitoa's own modules refer to each
other with `:local/root`, and tools.deps can't compare a local root with a git
sha. To fix it, declare `io.github.dunnage.sitoa/xml-primitives` at the top
level of your deps.edn, because top-level declarations always win. Depending
on sitoa's `serde` directly needs no extra step.

## The data

The shape is sitoa's XML binding of `fop.xsd`. An element is `[tag content]`,
and `content` is a map holding:

- **attributes**, as keyword keys with string values: `{:font-size "12pt"}`.
- **child elements named in the schema**, keyed by tag. A child that can repeat
  takes a vector of content maps. A child that can't takes a single content map:
  ```clojure
  [:table {:table-column [{:column-width "30%"} {:column-width "70%"}]   ; many
           :table-body   [{:xml/value [...rows...]}]}]                  ; many
  [:page-sequence {:master-reference "A4" :flow {...}}]                 ; one
  ```
- **`:xml/value`**, for elements whose children are an ordered sequence. It
  takes one of two forms, depending on the element:

  | Content | Elements | `:xml/value` holds |
  |---|---|---|
  | element content | `flow`, `static-content`, `table-cell`, `table-body`, `table-header`, `table-footer`, `block-container`, `list-item-label`, `list-item-body`, `footnote-body`, `float`, `layout-master-set`, ... | a vector of `[tag content]` elements |
  | mixed content | `block`, `inline`, `basic-link`, `wrapper`, `leader`, `marker`, `title`, `bidi-override`, ... | a vector of strings and **hiccup** `[tag attrs? & children]` |

A mixed-content `:xml/value` is always a vector of children, even when it
holds a single element: write `[[:inline {...} "x"]]`, not
`[:inline {...} "x"]`. sitoa's unparser would read the latter as the block's
own body and drop the inline. Validation rejects it.

So the same element is written two ways, depending on its parent:

```clojure
;; in a flow (element content): sitoa form
[:block {:font-size "10pt" :xml/value ["text"]}]

;; inside a block (mixed content): hiccup, nested as deep as you like
[:block {:xml/value ["Total: " [:inline {:font-weight "bold"} "42"]
                     [:block {:space-before "6pt"} "a nested block"]]}]
```

Elements with only attributes (`external-graphic`, `page-number`,
`region-body`, `table-column`, ...) are just `[tag {attrs}]`. Use `{}` when
there are no attributes. `fo/element-tags` is the set of all element tags.

Foreign content goes in hiccup. `fop.xsd` gives `instream-foreign-object` no
content model, so put it in mixed content. An `:xmlns` attribute puts an
element and its subtree in that namespace:

```clojure
[:block {:xml/value [[:instream-foreign-object {}
                      [:svg {:xmlns "http://www.w3.org/2000/svg" :width "20pt" :height "20pt"}
                       [:rect {:width "10" :height "10" :fill "red"}]]]]}]
```

## Validation

```clojure
(fo/valid? x)          ; x is [tag content]: a whole [:root ...] document, or any element
(fo/explain x)         ; malli explanation, or nil
(fo/validate x)        ; returns x, or throws ex-info {:type ::fo/invalid :errors <humanized> ...}
(fo/schema :table)     ; malli schema of one element; (fo/schema) accepts any element
(fo/registry)          ; for your own schemas: [:vector :clj-xml-fo.element/block]
```

Errors point at the element the data names. They don't list every
alternative:

```clojure
(malli.error/humanize (fo/explain [:block {:fnot-size "12pt"}]))
;=> [nil {:fnot-size ["disallowed key"]}]
```

What validation checks:

- **Element structure, closed maps and attribute names.** This matters because
  sitoa's unparser writes only what the schema names. A misspelt attribute is
  dropped silently unless you validate.
- **Attribute values against `fop.xsd`.** This is the strict default. `fop.xsd`
  has no grammar for property expressions (`label-end()`, `body-start()`,
  `rgb(...)`, `2pt + 3pt`), and it is narrower than FOP in places (lowercase hex
  colours, unitless `0`, lowercase language codes). Pass `{:lenient? true}` to
  accept any string value while still checking structure and names. Half of
  FOP's own examples need it.
- **Not checked:** the inside of mixed content. Hiccup is only checked to be a
  vector.

`fop.xsd` describes XSL-FO 1.0 as FOP implements it. XSL 1.1 additions such as
`fo:bookmark-tree` and `fo:change-bar` are not in the schema.

## Encoding and rendering

```clojure
(fo/render! doc out)                        ; PDF to an OutputStream, File or path
(fo/render! doc out {:mime "image/png"})    ; any FOP output format
(fo/render! doc out {:fop-factory (org.apache.fop.apps.FopFactory/newInstance (java.io.File. "fop.xconf"))})
(fo/render! doc out {:validate? true :lenient? true})

(fo/encode! doc content-handler)            ; SAX events into any org.xml.sax.ContentHandler
(fo/write-xml! doc out)                     ; FO XML to a Writer, OutputStream, File or path
(fo/xml-string doc)
```

`render!` hands the data to FOP's SAX handler. sitoa's unparser writes StAX
events with bare local names, and a small `XMLStreamWriter` → `ContentHandler`
bridge (`clj-xml-fo.impl.sax`) puts them in the XSL-FO namespace. With
`:validate? true`, a fully built document is checked before FOP is created, so
nothing invalid reaches it and no partial file is written.

## Streaming

Anywhere a document takes a sequence of elements, you can pass a stream in
place of a vector. That covers root's `:page-sequence`, a flow's `:xml/value`,
table rows and cells, list items, and mixed content. A stream is a lazy seq, an
`eduction`, or any `IReduceInit`:

```clojure
(fo/render!
  [:root {:layout-master-set {...}
          :page-sequence [{:master-reference "A4"
                           :flow {:flow-name "xsl-region-body"
                                  :xml/value [[:block {:xml/value ["Report"]}]
                                              [:table {:table-column [...]
                                                       :table-body [{:xml/value (eduction (map row->fo) (jdbc/plan ds query))}]}]]}}]}]
  "report.pdf")
```

Fully built subtrees still go through sitoa's unparser in one call. An element
that holds a stream is opened by hand from its schema, and the stream is
consumed with `reduce`, once. Each item reaches FOP before the next one is
produced. Streams nested among vector items are spliced in, as in hiccup.

- To keep memory flat, use an `eduction` over a reducible source. A lazy seq
  held by the document stays in memory as it is realized.
- `fo/valid?` on a document with streams would consume them. Use
  `{:validate? true}` on `render!`/`encode!` instead. Each streamed item is
  validated as it arrives and must be an element its parent allows. Errors
  carry a `:path` (e.g. `[1 :page-sequence 0 :flow :xml/value 3 1]`). An
  element wrapped around a stream has its attributes, its keys and its
  required keys checked. The order and count of streamed items are not
  checked.
- FOP lays out a page-sequence only after it has read all of it. Streaming
  bounds memory on the Clojure side, but a huge table in one page-sequence
  still grows inside FOP. Split long output over several page-sequences, which
  can themselves be a stream.

## Regenerating the schema

`generated/` is the output of sitoa's bootstrap and is committed. To rebuild it
from `bootstrap/clj_xml_fo/fop.xsd` (Apache FOP's schema, copied unmodified
from tag `fop-2_11`):

```bash
clojure -X:bootstrap
```

The `:bootstrap` alias adds the `bootstrap/` path and sitoa's
`bootstrapped-schema`, then runs `clj-xml-fo.bootstrap/generate!`. That calls
`dunnage.sitoa.schema-namespaces/xsd->namespaces!`, which writes one namespace
per XSD type plus the entry namespace `clj-xml-fo.schema`. It deletes stale
generated files first. The output is deterministic.

The generated registry is shaped for sitoa's serde, which never asks malli for
a validator. `clj-xml-fo.impl.validation` derives the validation registry from
it at load time. That namespace's docstring lists each adjustment and why it's
needed.

## Tests

```bash
clojure -X:test
```

Besides unit tests, the suite reads eight of Apache FOP's example documents
(`test-resources/fop-examples`) with sitoa's parser. For each one it validates
the data and checks that encoding and re-parsing returns the same data. For
seven of them it also checks that FOP lays the data out exactly as it lays out
the original file, comparing FOP area trees word for word and position for
position. The eighth, `list.fo`, has whitespace-only inlines, which sitoa's
parser drops when reading, so its layout differs slightly.

## License

MIT; see [LICENSE](LICENSE). `bootstrap/clj_xml_fo/fop.xsd` and
`test-resources/fop-examples/` come from Apache FOP and are under the Apache
License 2.0.
