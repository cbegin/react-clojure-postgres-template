(ns api.routes-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :refer :all]
            [api.routes :refer :all]
            [cheshire.core :refer :all]))

(defn setup-teardown [f]
  (binding [api.db/*db* "postgresql://echo:echo@localhost:5432/echo"]
    (f)))

(use-fixtures :once setup-teardown)

(defn json-req [app method uri body]
  (let [request (-> (request method uri (generate-string body))
                    (header "Content-Type" "application/json"))
        response (app request)
        parsed-response (assoc response :body (parse-string (:body response) true))]
    parsed-response))

(deftest test-app
  (testing "users endpoint"
    (let [response (json-req app :get "/v1/template/echo/hello" {:params {:example "unused"}})]
      (is (= 200 (:status response)))
      (is (= "hello" (get-in response [:body :message])))
      (is (= "application/json" (get-in response [:headers "Content-Type"]))))))
