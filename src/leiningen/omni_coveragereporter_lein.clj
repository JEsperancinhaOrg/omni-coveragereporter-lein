(ns leiningen.omni-coveragereporter-lein
  (:require [clojure.core]
            [clojure.java.io :as io]))

(defn omni-coveragereporter-lein
  "I don't do a lot."
  [_ & _]
  (println "Hi!")
  (.getCanonicalPath (clojure.java.io/file "."))
  (println (.getCanonicalPath (clojure.java.io/file ".")))
  (println (slurp (io/resource "banner.txt")))
  )
