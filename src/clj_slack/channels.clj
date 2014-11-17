(ns clj-slack.channels
  (:use [clj-slack.core :only [slack-request]])
  (:refer-clojure :exclude [list]))

(defn history
  "Fetches history of messages and events from a channel."
  [channel-id]
  (slack-request "channels.history" channel-id))

(defn info
  "Gets information about a channel."
  [channel-id]
  (slack-request "channels.info" channel-id))

(defn invite
  "Invites a user to a channel."
  [channel-id user-id]
  (slack-request "channels.invite" channel-id user-id))

(defn join
  "Joins a channel, creating it if needed."
  [channel-name]
  (slack-request "channels.join" channel-name))

(defn kick
  "Removes a user from a channel."
  [channel-id user-id]
  (slack-request "channels.kick" channel-id user-id))

(defn leave
  "Leaves a channel."
  [channel-id]
  (slack-request "channels.leave" channel-id))

(defn list
  "List channels"
  []
  (slack-request "channels.list"))

(defn mark
  "Sets the read cursor in a channel."
  [channel-id timestamp]
  (slack-request "channels.mark" channel-id timestamp))

(defn rename
  "Rename a channel."
  [channel-id name]
  (slack-request "channels.rename" channel-id name))

(defn set-purpose
  "Sets the purpose for a channel."
  [channel-id purpose]
  (slack-request "channels.setPurpose" channel-id purpose))

(defn set-topic
  "Sets the topic for a channel."
  [channel-id topic]
  (slack-request "channels.setTopic" channel-id topic))
