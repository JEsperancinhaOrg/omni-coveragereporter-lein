(ns leiningen.omni-coveragereporter-lein
  (:require [clojure.core]))

(defn omni-coveragereporter-lein
  "I don't do a lot."
  [project & args]
  (println "Hi!")
  (.getCanonicalPath (clojure.java.io/file "."))
  (println(.getCanonicalPath (clojure.java.io/file ".")))
  )
