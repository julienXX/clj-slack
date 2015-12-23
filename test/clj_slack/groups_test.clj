(ns clj-slack.groups-test
  (:require [clojure.test :refer :all]
            [clj-slack.groups :refer :all]))

(def connection {:api-url "https://slack.com/api" :token (System/getenv "TOKEN")})

(deftest group-info
  (testing "Require group info"
    (is (:ok (clj-slack.groups/info connection "C03PHJ58Z")))))
