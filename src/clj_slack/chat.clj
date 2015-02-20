(ns clj-slack.chat
  (:use [clj-slack.core :only [slack-request]]))

(defn ^:private parse-extras
  "Takes a sequence and turns it into a hashmap where keys are strings."
  [extras]
  (into {} (for [[k v] (partition 2 extras)]
             (if (keyword? k)
                 [(name k) v]
                 [(str k) v]))))

(defn delete
  "Deletes a message."
  [connection timestamp channel-id]
  (slack-request connection "chat.delete" {"ts" timestamp "channel" channel-id}))

(defn post-message
  "Sends a message to a channel."
  [connection channel-id text & extras]
  (let [extras-map (parse-extras extras)
        post-message-args (merge {"channel" channel-id "text" text} extras-map)]
    (slack-request connection "chat.postMessage" post-message-args)))

(defn update
  "Sends a message to a channel."
  [connection timestamp channel-id text]
  (slack-request connection "chat.update" {"ts" timestamp "channel" channel-id "text" text}))
