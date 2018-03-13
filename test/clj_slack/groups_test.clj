(ns clj-slack.groups-test
  (:require [clojure.test :refer :all]
            [clj-slack.groups :refer :all])
  (:refer-clojure :exclude [list]))

(def connection {:api-url "https://slack.com/api" :token (System/getenv "TOKEN")})

(deftest group-list
  (testing "Listing groups"
    (is (:ok (clj-slack.groups/list connection)))))
