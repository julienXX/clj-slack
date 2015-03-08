(ns clj-slack.core-test
  (:require [clojure.test   :refer :all]
            [clj-slack.core :refer :all]))

(deftest token-present
  (testing "API token is present in the build system"
    (is (System/getenv "TOKEN"))))

(deftest stringify-keys-test
  (testing "Converts map keys to strings"
    (let [map {:foo "bar" :foo2 "baz"}]
      (is (= {"foo" "bar", "foo2" "baz"} (stringify-keys map))))))

(deftest make-query-string-test
  (testing "Making query params from map"
    (let [map {"foo" "bar" "foo2" "baz"}]
      (is (= "foo=bar&foo2=baz" (#'clj-slack.core/make-query-string map))))))

(deftest build-params-test
  (testing "Building query params from connection, endpoint and map"
    (let [connection {:api-url "http://foo.bar" :token "TOKEN"}
          endpoint "users"
          map {"foo" "bar" "foo2" "baz"}]
      (is (= "/users?token=TOKEN&foo=bar&foo2=baz" (#'clj-slack.core/build-params connection endpoint map))))))
