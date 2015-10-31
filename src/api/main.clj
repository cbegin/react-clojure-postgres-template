(ns api.main
  (:require [ring.adapter.jetty :as jetty]
            [api.service :refer [app]])
  (:gen-class))

(defn -main [& args]
  (jetty/run-jetty app {:port 8080}))
