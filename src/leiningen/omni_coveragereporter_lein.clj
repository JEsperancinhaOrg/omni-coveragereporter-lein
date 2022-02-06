(ns leiningen.omni-coveragereporter-lein
  (:require [cheshire.core :as json]
            [clojure.core]
            [clojure.java.io :as io]))

(def banner (io/resource
              "banner.txt"))

(def text (json/encode {:message "hello omni!"}))

(defn omni-coveragereporter-lein
  "Omni Coverage Plugin For Leiningen Repos.
  Check https://leiningen.org/ for further details on how to use these repos"
  [_ & args]
  ;(.getCanonicalPath (clojure.java.io/file "."))
  ;(println (.getCanonicalPath (clojure.java.io/file ".")))
  (println (slurp banner))
  (println (apply str text))
  (println (apply str args)))

