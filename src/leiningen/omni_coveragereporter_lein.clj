(ns leiningen.omni-coveragereporter-lein
  (:require [cheshire.core :as json]
            [clojure.core]
            [clojure.java.io :as io])
  (:import (java.io FileReader)))

(def banner (io/resource
              "banner.txt"))

(defn omni-coveragereporter-lein
  "Omni Coverage Plugin For Leiningen Repos.
  Check https://leiningen.org/ for further details on how to use these repos"
  [_ & _]
  (println (.getCanonicalPath (clojure.java.io/file ".", "omni-config.json")))
  (println (slurp banner))
  (println "* Starting reporting...")
  (let [config-file (.getCanonicalPath (clojure.java.io/file ".", "omni-config.json"))
        configuration (slurp (FileReader. config-file))]
        (println config-file)
        (println configuration))
  (println "* Reporting Finished!"))

