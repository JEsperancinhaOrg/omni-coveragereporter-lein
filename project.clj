(defproject omni-coveragereporter-lein "0.0.0"
  :name omni-coveragereporter-lein
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [
                 [org.clojure/tools.logging "1.2.4"]
                 [org.slf4j/slf4j-api "1.6.2"]
                 [org.slf4j/slf4j-log4j12 "1.6.2"]
                 [org.clojure/clojure "1.10.3"]
                 [log4j "1.2.17"]
                 [org.jesperancinha.plugins/omni-coveragereporter-commons "0.2.0"]
                 [cheshire "5.9.0"]
                 [org.jetbrains.kotlin/kotlin-stdlib "1.6.10"]
                 [org.apache.logging.log4j/log4j-core "2.17.1"]
                 [commons-logging "1.2"]
                 [ch.qos.logback/logback-classic "1.2.10"]
                 [org.apache.logging.log4j/log4j-slf4j-impl "2.17.1"]
                 ]
  :repositories {"local" ~(str (.toURI (java.io.File. "maven_repository")))}
  :repl-options {:init-ns test.core}
  :profiles {
             :run      {:eval-in-leiningen true
                        :plugins           [[omni-coveragereporter-lein "0.0.0"]]}
             :coverage {:eval-in-leiningen false
                        :plugins           [[lein-cloverage "1.2.2"]]}}
  )
