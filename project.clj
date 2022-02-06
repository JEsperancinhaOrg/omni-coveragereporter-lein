(defproject omni-coveragereporter-lein "0.0.0-SNAPSHOT"
  :name omni-coveragereporter-lein
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]]
  ;:eval-in-leiningen false
  :repl-options {:init-ns test.core}
  :profiles {
             :run      {:dependencies      [[org.clojure/clojure "1.10.3"]]
                        :eval-in-leiningen true
                        :plugins           [[omni-coveragereporter-lein "0.0.0-SNAPSHOT"]]}
             :coverage {:dependencies      [[org.clojure/clojure "1.10.3"]]
                        :eval-in-leiningen false
                        :plugins           [[lein-cloverage "1.2.2"]]
                        }}
  )
