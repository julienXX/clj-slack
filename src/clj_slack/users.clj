(ns clj-slack.users
  (:use [clj-slack.core :only [slack-request]])
  (:refer-clojure :exclude [list]))

(defn list
  "List users"
  []
  (slack-request "users.list"))
