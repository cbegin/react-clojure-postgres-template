(ns api.db-test
  (:require [clojure.test :refer :all]
            [api.db :as db]))

(defn setup-teardown [f]
  (binding [api.db/*db* "postgresql://echo:echo@localhost:5432/echo"]
    (f)))

(use-fixtures :once setup-teardown)

(deftest test-echo
  (db/delete-all-echos)
  (let [inserted-echo (first (db/insert-echo "Hello"))
        selected-echos-after-insert (db/select-all-echos)
        deleted-echos (first (db/delete-all-echos))
        selected-echos-after-delete (db/select-all-echos)]
    (db/delete-all-echos)
    (testing "echo db"
      (is (= (keys inserted-echo) '(:message :created_on)))
      (is (= selected-echos-after-insert '({:message "Hello"}))))
    (is (= selected-echos-after-delete '()))
    (is (= deleted-echos 1))))
