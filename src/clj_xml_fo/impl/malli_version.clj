(ns clj-xml-fo.impl.malli-version
  "clj-xml-fo needs metosin/malli 0.20.2 or newer. The FO schema is large
  and recursive through refs: 0.20.1 compiles recursive validators instead
  of re-deriving them, and 0.20.2 fixes a startup-time regression and
  malli.error/humanize failures on some schemas.

  deps.edn names 0.20.2, and tools.deps picks the newest version any
  dependency asks for, so 0.20.2 is a floor, except that a version pinned at
  the top level of a consumer's deps.edn always wins, however old. check!
  turns that into a clear failure at load time instead of slow validation.

  malli's jar carries no version metadata, so the version is read from the
  name of the jar malli was loaded from. When malli comes from somewhere
  without one (a git or local dependency, an uberjar), there is nothing to
  check and loading goes ahead."
  (:require [clojure.java.io :as io]))

(def minimum "0.20.2")

(defn parse
  "[major minor patch] of a version string, ignoring any qualifier, or nil."
  [s]
  (when-some [[_ & parts] (re-find #"^(\d+)\.(\d+)\.(\d+)" (str s))]
    (mapv parse-long parts)))

(defn at-least?
  [version floor]
  (let [v (parse version) f (parse floor)]
    (boolean (and v f (not (neg? (compare v f)))))))

(defn from-url
  "malli's version from the URL of a resource inside its jar, e.g.
  jar:file:/.../malli-0.20.2.jar!/malli/core.cljc, else nil."
  [url]
  (second (re-find #"/malli-(\d+\.\d+\.\d+[^/!]*)\.jar!/" (str url))))

(defn on-classpath
  "The version of the malli jar on the classpath, or nil when unknown."
  []
  (from-url (io/resource "malli/core.cljc")))

(defn check!
  "Throw when the malli on the classpath is known to be older than minimum."
  []
  (when-some [v (on-classpath)]
    (when-not (at-least? v minimum)
      (throw (ex-info (str "clj-xml-fo requires metosin/malli " minimum " or newer, but "
                           v " is on the classpath. Remove or raise the malli version"
                           " pinned in your deps.edn.")
                      {:type     :clj-xml-fo.core/malli-version
                       :required minimum
                       :found    v
                       :url      (str (io/resource "malli/core.cljc"))})))))

;; Runs when this namespace loads. clj-xml-fo.core requires it first, so an old
;; malli is reported before anything else is compiled against it.
(check!)
