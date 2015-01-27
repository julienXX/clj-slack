(ns clj-slack.users
  (:use [clj-slack.core :only [slack-request connection]])
  (:refer-clojure :exclude [list]))

(defn info
  "Gets information about a user."
  [& {:keys [connection user-id]
      :or {connection (connection)}}]
  (slack-request :connection connection :endpoint "users.info" :query {"user" user-id}))

(defn list
  "Lists all users in a Slack team."
  [& {:keys [connection]
      :or {connection (connection)}}]
  (slack-request :connection connection :endpoint "users.list"))

(defn set-active
  "Marks a user as active."
  [& {:keys [connection]
      :or {connection (connection)}}]
  (slack-request "users.setActive"))
