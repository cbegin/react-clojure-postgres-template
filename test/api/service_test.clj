(ns api.service-test
  (:require [clojure.test :refer :all]
            [api.service :refer :all]))

(defn setup-teardown [f]
  (binding [api.db/*db* "postgresql://echo:echo@localhost:5432/echo"]
    (f)))

(use-fixtures :once setup-teardown)

(deftest test-logic
  (testing "echo function"
    (let [value (get-in (echo "foo") [:body :message])]
      (is (= value "foo")))))

