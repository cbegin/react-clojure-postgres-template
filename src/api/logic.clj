(ns api.logic
  (:require [api.db :as db]
            [clojure.string :as str]))

(defn echo [message]
  {:status 200
   :body   {:message message}})
