(ns clj-slack.chat
  (:use [clj-slack.core :only [slack-request stringify-keys]]))

(defn delete
  "Deletes a message."
  [connection timestamp channel-id]
  (slack-request connection "chat.delete" {"ts" timestamp "channel" channel-id}))

(defn post-message
  "Sends a message to a channel."
  ([connection channel-id text]
     (post-message channel-id text {}))
  ([connection channel-id text extras]
     (->> extras
          stringify-keys
          (merge {"channel" channel-id
                  "text" text})
          (slack-request connection "chat.postMessage"))))

(defn update
  "Sends a message to a channel."
  [connection timestamp channel-id text]
  (slack-request connection "chat.update" {"ts" timestamp "channel" channel-id "text" text}))
