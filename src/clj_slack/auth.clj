(ns clj-slack.auth
  (:use [clj-slack.core :only [slack-request]])
  (:refer-clojure :exclude [test]))

(defn test
  []
  (slack-request "auth.test"))
