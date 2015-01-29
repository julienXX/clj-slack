(ns clj-slack.users
  (:use [clj-slack.core :only [slack-request]])
  (:refer-clojure :exclude [list]))

(defn info
  "Gets information about a user."
  [connection user-id]
  (slack-request connection "users.info" {"user" user-id}))

(defn list
  "Lists all users in a Slack team."
  [connection]
  (slack-request connection "users.list"))

(defn set-active
  "Marks a user as active."
  [connection]
  (slack-request connection "users.setActive"))
