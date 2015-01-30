(ns clj-slack.channels
  (:use [clj-slack.core :only [slack-request]])
  (:refer-clojure :exclude [list]))

(defn archive
  "Archives a channel."
  [connection channel-id]
  (slack-request connection "channels.archive" {"channel" channel-id}))

(defn create
  "Creates a channel."
  [connection name]
  (slack-request connection "channels.create" {"name" name}))

(defn history
  "Fetches history of messages and events from a channel."
  [connection channel-id]
  (slack-request connection "channels.history" {"channel" channel-id}))

(defn info
  "Gets information about a channel."
  [connection channel-id]
  (slack-request connection "channels.info" {"channel" channel-id}))

(defn invite
  "Invites a user to a channel."
  [connection channel-id user-id]
  (slack-request connection "channels.invite" {"channel" channel-id "user" user-id}))

(defn join
  "Joins a channel, creating it if needed."
  [connection channel-name]
  (slack-request connection "channels.join" {"channel" channel-name}))

(defn kick
  "Removes a user from a channel."
  [connection channel-id user-id]
  (slack-request connection "channels.kick" {"channel" channel-id "user" user-id}))

(defn leave
  "Leaves a channel."
  [connection channel-id]
  (slack-request connection "channels.leave" {"channel" channel-id}))

(defn list
  "List channels"
  [connection]
  (slack-request connection "channels.list"))

(defn mark
  "Sets the read cursor in a channel."
  [connection channel-id timestamp]
  (slack-request connection "channels.mark" {"channel" channel-id "ts" timestamp}))

(defn rename
  "Rename a channel."
  [connection channel-id name]
  (slack-request connection "channels.rename" {"channel" channel-id "name" name}))

(defn set-purpose
  "Sets the purpose for a channel."
  [connection channel-id purpose]
  (slack-request connection "channels.setPurpose" {"channel" channel-id "purpose" purpose}))

(defn set-topic
  "Sets the topic for a channel."
  [connection channel-id topic]
  (slack-request connection "channels.setTopic" {"channel" channel-id "topic" topic}))

(defn unarchive
  "Unarchives a channel."
  [connection channel-id]
  (slack-request connection "channels.unarchive" {"channel" channel-id}))
