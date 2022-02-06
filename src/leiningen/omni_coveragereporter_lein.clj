(ns leiningen.omni-coveragereporter-lein
  (:require [clojure.core]
            [clojure.java.io :as io]))

(def banner (io/resource
              "banner.txt" ))
(defn omni-coveragereporter-lein
  "Omni Coverage Plugin For Leiningen Repos.
  Check https://leiningen.org/ for further details on how to use these repos"
  [_ & _]
  ;(.getCanonicalPath (clojure.java.io/file "."))
  ;(println (.getCanonicalPath (clojure.java.io/file ".")))
  (println (slurp banner))
  )
