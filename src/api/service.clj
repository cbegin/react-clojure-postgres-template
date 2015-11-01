(ns api.service
  (:require [api.db :as db]))

(defn echo [message]
  (db/delete-all-echos)
  (db/insert-echo message)
  {:status 200
   :body   (first (db/select-all-echos))})
