(defproject omni-coveragereporter-lein "0.0.0-SNAPSHOT"
  :name omni-coveragereporter-lein
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [
                 [org.clojure/clojure "1.10.3"]
                 [org.jesperancinha.plugins/omni-coveragereporter-commons "0.1.5"]
                 [cheshire "5.9.0"]
                 ]
  :repl-options {:init-ns test.core}
  :profiles {
             :run      {:eval-in-leiningen true
                        :plugins           [[omni-coveragereporter-lein "0.0.0-SNAPSHOT"]]
                        :gotome gotome}
             :coverage {:eval-in-leiningen false
                        :plugins           [[lein-cloverage "1.2.2"]]}}
  )
