(ns api.routes
  (:require [clojure.pprint :refer [pprint]]
            [ring.middleware.nested-params :refer :all]
            [ring.middleware.keyword-params :refer :all]
            [ring.middleware.params :refer :all]
            [ring.middleware.json :refer :all]
            [ring.util.response :refer :all]
            [compojure.core :refer [routes context rfn GET POST]]
            [compojure.route :as route]
            [compojure.response :as response]
            [ring.util.response :as ring]
            [api.service :as logic]
            [jdbc.pool.c3p0 :as pool])
  (:gen-class))

(def dbspec (pool/make-datasource-spec {:classname "org.postgresql.Driver"
                                        :subprotocol "postgresql"
                                        :user "echo"
                                        :password "echo"
                                        :subname     "//localhost:5432/echo"}))

(defn wrap-transaction [handler]
  (fn [req]
    (binding [api.db/*db* dbspec]
      (handler req))))

(defn wrap-utf8 [handler]
  (fn [req]
    (content-type (handler req) "application/json")))

(defn static-resource [body]
  (rfn request
    (-> (response/render body request)
        (status 200))))

(defn app-routes []
  (routes
    (context "/v1" {body :body :as request}
      (-> (context "/template" {body :body :as request}
            (GET "/echo/:message" [message] (logic/echo message)))
          (wrap-transaction)
          (wrap-utf8)))
    (route/resources "/")
    (static-resource (ring/resource-response "app/index.html" {:root "public"}))))

(def app
  (-> (app-routes)
      (wrap-keyword-params)
      (wrap-nested-params)
      (wrap-params)
      (wrap-json-body {:keywords? true})
      (wrap-json-response)))
