(ns leiningen.omni-coveragereporter-lein)

(defn omni-coveragereporter-lein
  "I don't do a lot."
  [project & args]
  (println "Hi!")
  (.getCanonicalPath (clojure.java.io/file "."))
  (println(.getCanonicalPath (clojure.java.io/file ".")))
  )
