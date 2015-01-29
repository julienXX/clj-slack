(ns clj-slack.chat
  (:use [clj-slack.core :only [slack-request]]))

(defn delete
  "Deletes a message."
  [connection timestamp channel-id]
  (slack-request connection "chat.delete" {"ts" timestamp "channel" channel-id}))

(defn post-message
  "Sends a message to a channel."
  [connection channel-id text]
  (slack-request connection "chat.postMessage" {"channel" channel-id "text" text}))

(defn update
  "Sends a message to a channel."
  [connection timestamp channel-id text]
  (slack-request connection "chat.update" {"ts" timestamp "channel" channel-id "text" text}))
