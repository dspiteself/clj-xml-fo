(ns build
  "Release tasks for clj-xml-fo.

    clojure -T:build jar       target/clj-xml-fo-<version>.jar and its pom
    clojure -T:build install   the jar into ~/.m2, to try it from another project
    clojure -T:build deploy    the jar to Clojars

  deploy reads CLOJARS_USERNAME and CLOJARS_PASSWORD (a Clojars deploy token)
  from the environment. The version is 0.1.<number of commits>, so commit
  before releasing and tag the commit v<version> afterwards."
  (:require [clojure.string :as str]
            [clojure.tools.build.api :as b]
            [deps-deploy.deps-deploy :as dd]))

(def lib 'io.github.dunnage/clj-xml-fo)
(def version (format "0.1.%s" (b/git-count-revs nil)))
(def class-dir "target/classes")
(def jar-file (format "target/%s-%s.jar" (name lib) version))
(def repo "https://github.com/dunnage/clj-xml-fo")

(defn- basis []
  (b/create-basis {:project "deps.edn"}))

(defn- non-maven-deps
  "Direct dependencies a pom cannot express. tools.build leaves git and local
  deps out of the pom, so a jar published with any of them would be missing
  those libraries for everyone who depends on it through Maven."
  [basis]
  (into (sorted-map)
        (remove (fn [[_ coord]] (contains? coord :mvn/version)))
        (:deps basis)))

(defn- warn-or-refuse! [basis refuse?]
  (when-some [deps (not-empty (non-maven-deps basis))]
    (let [message (str "These dependencies are not Maven artifacts and will be missing from the pom:\n"
                       (str/join "\n" (map (fn [[lib coord]] (str "  " lib " " (pr-str coord))) deps))
                       "\nPublish them to a Maven repository and use :mvn/version coordinates in deps.edn.")]
      (if refuse?
        (throw (ex-info (str "Refusing to deploy. " message) {:deps deps}))
        (binding [*out* *err*]
          (println "WARNING:" message))))))

(defn clean [_]
  (b/delete {:path "target"}))

(defn jar
  "Build the jar: the sources under src/ and generated/, LICENSE and NOTICE,
  and a pom with the project's metadata."
  [opts]
  (let [basis (basis)]
    (warn-or-refuse! basis false)
    (clean opts)
    (b/write-pom {:class-dir class-dir
                  :lib       lib
                  :version   version
                  :basis     basis
                  :src-dirs  ["src"]
                  :scm       {:url                 repo
                              :connection          (str "scm:git:" repo ".git")
                              :developerConnection "scm:git:ssh://git@github.com/dunnage/clj-xml-fo.git"
                              :tag                 (b/git-process {:git-args "rev-parse HEAD"})}
                  :pom-data  [[:description "XSL-FO as Clojure data: malli validation generated from Apache FOP's fop.xsd, encoded with sitoa straight into Apache FOP, with streaming."]
                              [:url repo]
                              [:licenses
                               [:license
                                [:name "MIT License"]
                                [:url "https://opensource.org/license/mit"]]]
                              [:developers
                               [:developer
                                [:name "Tyler Tallman"]]]]})
    (b/copy-dir {:src-dirs ["src" "generated"] :target-dir class-dir})
    (b/copy-file {:src "LICENSE" :target (str class-dir "/META-INF/clj-xml-fo/LICENSE")})
    (b/copy-file {:src "NOTICE" :target (str class-dir "/META-INF/clj-xml-fo/NOTICE")})
    (b/jar {:class-dir class-dir :jar-file jar-file})
    (println "Built" jar-file)
    jar-file))

(defn install
  "Install the jar into the local Maven repository."
  [opts]
  (jar opts)
  (b/install {:basis     (basis)
              :lib       lib
              :version   version
              :jar-file  jar-file
              :class-dir class-dir})
  (println "Installed" lib version))

(defn deploy
  "Deploy the jar to Clojars. Refuses while any dependency is not a Maven
  artifact, since the published pom could not bring it in."
  [opts]
  (warn-or-refuse! (basis) true)
  (jar opts)
  (dd/deploy {:installer :remote
              :artifact  (b/resolve-path jar-file)
              :pom-file  (b/pom-path {:lib lib :class-dir class-dir})})
  (println "Deployed" lib version))
