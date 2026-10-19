(ns clj-xml-fo.bootstrap
  "Regenerates the XSL-FO malli schema under generated/ from fop.xsd with
  sitoa's bootstrapped-schema.

  This namespace, the XSD and sitoa's XSD tooling (XSOM/JAXB) are only on the
  classpath under the :bootstrap alias; the library itself never loads them:

    clojure -X:bootstrap

  bootstrap/clj_xml_fo/fop.xsd is Apache FOP's own schema, copied unmodified
  from https://github.com/apache/xmlgraphics-fop at tag fop-2_11
  (fop/src/foschema/fop.xsd), Apache License 2.0."
  (:require [clojure.java.io :as io]
            [dunnage.sitoa.schema-namespaces :as sn])
  (:import (java.io File)))

(def defaults
  {:xsd      "clj_xml_fo/fop.xsd"
   :out-dir  "generated"
   :entry-ns 'clj-xml-fo.schema})

(defn- clean!
  "sitoa overwrites generated files but never deletes them, so a type dropped
  from the XSD would leave a stale namespace behind. Removes only .cljc files
  and the directories they leave empty, never out-dir itself."
  [out-dir]
  (let [root (io/file out-dir)]
    (when (.exists root)
      ;; file-seq is pre-order, so reversed it visits children before parents.
      (doseq [^File f (reverse (file-seq root))
              :when (not= f root)]
        (cond
          (and (.isFile f) (.endsWith (.getName f) ".cljc")) (io/delete-file f)
          (and (.isDirectory f) (empty? (.list f))) (io/delete-file f))))))

(defn generate!
  "Exec fn for -X:bootstrap. Every option is optional:

    :xsd       classpath resource of the XSD (default clj_xml_fo/fop.xsd)
    :out-dir   directory the namespaces are written under (default generated)
    :entry-ns  aggregator namespace (default clj-xml-fo.schema)"
  [opts]
  (let [{:keys [xsd out-dir entry-ns]} (merge defaults opts)
        url (or (io/resource xsd)
                (throw (ex-info (str "XSD not found on the classpath: " xsd) {:xsd xsd})))]
    (clean! out-dir)
    (let [{:keys [files entry-file]} (sn/xsd->namespaces! {:default-ns "fo"
                                                           :out-dir    out-dir
                                                           :entry-ns   (symbol entry-ns)}
                                                          url)]
      (println "Wrote" (count files) "namespaces under" out-dir "- entry" entry-file))))
