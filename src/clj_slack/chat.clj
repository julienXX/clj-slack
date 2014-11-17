(ns clj-slack.chat
  (:use [clj-slack.core :only [slack-request]]))

(defn delete
  "Deletes a message."
  [timestamp channel-id]
  (slack-request "chat.delete" timestamp channel-id))

(defn post-message
  "Sends a message to a channel."
  [channel-id text]
  (slack-request "chat.postMessage" channel-id text))

(defn update
  "Sends a message to a channel."
  [timestamp channel-id text]
  (slack-request "chat.update" timestamp channel-id text))
