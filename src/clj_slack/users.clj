(ns clj-slack.users
  (:require [clj-slack.core :refer [slack-request]])
  (:refer-clojure :exclude [list]))

(defn get-presence
  "Gets user presence information."
  [connection user-id]
  (slack-request connection "users.getPresence" {"user" user-id}))

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

(defn set-presence
  "Manually sets user presence."
  [connection user-id presence]
  (slack-request connection "users.setPresence" {"user" user-id "presence" presence}))
