(ns clj-slack.chat
  (:use [clj-slack.core :only [slack-request]]))

(defn- parse-extras
  "Takes a sequence and turns it into a hashmap whose keys are strings"
  [extras]
  (let [extras-map (apply hash-map extras)]
    (into {} (for [[k v] extras-map]
               (if (keyword? k)
                 [(name k) v]
                 [(str k) v])))))

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
