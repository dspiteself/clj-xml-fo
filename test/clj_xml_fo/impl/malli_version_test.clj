(ns clj-xml-fo.impl.malli-version-test
  (:require [clj-xml-fo.impl.malli-version :as mv]
            [clojure.test :refer [deftest is]]))

(deftest compares-versions
  (is (mv/at-least? "0.20.2" "0.20.2"))
  (is (mv/at-least? "0.20.3" "0.20.2"))
  (is (mv/at-least? "0.21.0" "0.20.2"))
  (is (mv/at-least? "1.0.0-alpha1" "0.20.2"))
  (is (not (mv/at-least? "0.20.1" "0.20.2")))
  (is (not (mv/at-least? "0.19.10" "0.20.2")))
  (is (not (mv/at-least? "0.9.2" "0.20.2")))
  (is (not (mv/at-least? "nonsense" "0.20.2"))))

(deftest reads-the-version-from-the-jar
  (is (= "0.20.2" (mv/from-url "jar:file:/home/u/.m2/repository/metosin/malli/0.20.2/malli-0.20.2.jar!/malli/core.cljc")))
  (is (= "0.21.0-SNAPSHOT" (mv/from-url "jar:file:/r/malli-0.21.0-SNAPSHOT.jar!/malli/core.cljc")))
  (is (nil? (mv/from-url "file:/home/u/src/malli/src/malli/core.cljc")) "a local or git checkout")
  (is (nil? (mv/from-url "jar:file:/srv/app-standalone.jar!/malli/core.cljc")) "an uberjar")
  (is (nil? (mv/from-url nil))))

(deftest the-malli-under-test-is-new-enough
  (is (some? (mv/on-classpath)))
  (is (mv/at-least? (mv/on-classpath) mv/minimum))
  (is (nil? (mv/check!))))
