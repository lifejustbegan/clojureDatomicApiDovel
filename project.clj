(defproject samuel_datomic_clojure_dovel_api "0.1.0-SNAPSHOT"
  :description "clojure datomic simple api "
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
:plugins [[lein-ring "0.12.5"]
          [lein-autoexpect "1.9.0"]
          [lein-datomic "0.2.0"]
          [lein-vanity "0.2.0"]]
:datomic {:install-location "/Users/samuel/datomic-free-0.9.5703.21"}
:ring  {:handler samuel_datomic_clojure_dovel_api.core/app
          :auto-reload? true
          :auto-refresh? false}
:dependencies [[org.clojure/clojure "1.10.0"]
               [com.datomic/datomic-free "0.9.5697"]
               [expectations "2.1.10"]
               [ring/ring-core "1.7.1"]
               [compojure "1.6.1"]
               [ring/ring-json "0.5.0"]
               [hiccup-bridge "1.0.1"]]
:main ^:skip-aot samuel-datomic-clojure-dovel-api.core
:target-path "target/%s"
:profiles {:uberjar {:aot :all}})
