(defproject template "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/java.jdbc "0.6.1"]
                 [clojure.jdbc/clojure.jdbc-c3p0 "0.3.2"]
                 [postgresql "9.3-1102.jdbc41"]
                 [ring/ring-core "1.5.0"]
                 [ring/ring-jetty-adapter "1.5.0"]
                 [ring/ring-json "0.4.0"]
                 [compojure "1.5.1"]
                 [cheshire "5.6.3"]]

  :ring {:handler api.routes/app
         :port 8080}

  :main api.main

  :profiles {:dev {:dependencies [[ring/ring-mock "0.3.0"]]}
             :uberjar {:aot :all}}

  :plugins [[lein-ring "0.9.7"]])
