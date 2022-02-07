(ns leiningen.omni_coveragereporter_lein-test
  (:require [clojure.test :refer :all])
  (:require [leiningen.omni-coveragereporter-lein :refer [omni-coveragereporter-lein]]))

(deftest omni_coveragereporter_lein-test
  (omni-coveragereporter-lein ())
  )
