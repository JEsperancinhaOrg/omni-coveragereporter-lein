(ns org.jesperancinha.plugins.omni.coveragereporter.omni_coveragereporter_lein-test
  (:require [clojure.test :refer :all])
  (:require [org.jesperancinha.plugins.omni.coveragereporter.omni-coveragereporter-lein :refer [omni-coveragereporter-lein]]))

(deftest omni_coveragereporter_lein-test
  (omni-coveragereporter-lein ())
  )
