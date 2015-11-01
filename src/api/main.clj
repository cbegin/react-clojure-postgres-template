(ns api.main
  (:require [ring.adapter.jetty :as jetty]
            [api.routes :refer [app]])
  (:gen-class))

(defn -main [& args]
  (jetty/run-jetty app {:port 8080}))
