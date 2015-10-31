(ns api.routes-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :refer :all]
            [api.service :refer :all]
            [cheshire.core :refer :all]
            ))

(defn json-req [app uri body]
  (let [request (-> (request :get uri (generate-string body))
                    (header  "Content-Type" "application/json"))
        response (app request)
        parsed-response (assoc response :body (parse-string (:body response) true))]
    parsed-response))

(defn json [s]
  (parse-string s true))

(deftest test-app
  (testing "users endpoint"
    (let [response (json-req app "/v1/template/echo/hello" {:params {:example "unused"}})]
      (is (= 200 (:status response)))
      (is (= "hello" (get-in response [:body :message])))
      (is (= "application/json" (get-in response [:headers "Content-Type"]))))))
