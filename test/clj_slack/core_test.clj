(ns clj-slack.core-test
  (:require [clojure.test :refer :all]
            [clj-slack.core :refer :all]))

(deftest token-present
  (testing "API token is present in the build system"
    (is (System/getenv "TOKEN"))))
