(ns clj-slack.users
  (:use [clj-slack.core :only [slack-request]])
  (:refer-clojure :exclude [list]))

(defn info
  "Gets information about a user."
  [user-id]
  (slack-request "users.info" user-id))

(defn list
  "Lists all users in a Slack team."
  []
  (slack-request "users.list"))

(defn set-active
  "Marks a user as active."
  []
  (slack-request "users.setActive"))
