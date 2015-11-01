(ns api.db
  (:require [clojure.java.jdbc :as sql])
  (:import (java.sql Timestamp)
           (java.util Date)))

(def ^:dynamic *db*)

(defn select-all-echos []
  (sql/query *db* ["select message from echo"]))

(defn insert-echo [message]
  (let [echo {:message message :created_on (Timestamp. (.getTime (Date.)))}]
    (sql/insert! *db* :echo echo)))

(defn delete-all-echos []
  (sql/delete! *db* :echo []))
