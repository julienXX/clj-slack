(ns clj-slack.oauth-test
  (:require [clojure.test :refer :all]
            [clj-slack.oauth :refer :all]))

(def connection {:api-url "https://slack.com/api"})
(def client-id (System/getenv "CLIENT_ID"))
(def client-secret (System/getenv "CLIENT_SECRET"))

(deftest oauth-access
  (testing "Requesting a token with a temp code"
    (let [resp (clj-slack.oauth/access connection client-id client-secret "fake_temp_code" "http://example.com/fake/callback")]
      (is (and (false? (:ok resp)) (= "invalid_code" (:error resp)))))))
