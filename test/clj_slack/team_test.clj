(ns clj-slack.team-test
  (:require [clojure.test :refer :all]
            [clj-slack.team :refer :all]))

(def connection {:api-url "https://slack.com/api" :token (System/getenv "TOKEN")})

(defn missing-scope? [response]
  (= "missing_scope" (:error response)))

(deftest team-info
  (testing "Require team info"
    (is (:ok (clj-slack.team/info connection)))))

(deftest team-access-log
  (testing "Require team access log, if it errors it is because the user is not admin"
    (let [resp (clj-slack.team/access-log connection)]
      (is (or (:ok resp) (missing-scope? resp))))
    (let [resp (clj-slack.team/access-log connection {:count "10" :page "1"})]
      (is (or (:ok resp) (missing-scope? resp))))))
