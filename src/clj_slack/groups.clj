(ns clj-slack.groups
  (:use [clj-slack.core :only [slack-request]])
  (:refer-clojure :exclude [list]))

(defn create
  "Creates a private group."
  [connection name]
  (slack-request connection "groups.create" {"name" name}))

(defn create-child
  "Clones and archives a private group."
  [connection channel-id]
  (slack-request connection "groups.createChild" {"channel" channel-id}))

(defn history
  "Fetches history of messages and events from a private group."
  [connection channel-id]
  (slack-request connection "groups.history" {"channel" channel-id}))

(defn invite
  "Invites a user to a private group."
  [connection channel-id user-id]
  (slack-request connection "groups.invite" {"channel" channel-id "user" user-id}))

(defn kick
  "Removes a user from a private group."
  [connection channel-id user-id]
  (slack-request connection "groups.kick" {"channel" channel-id "user" user-id}))

(defn leave
  "Leaves a private group."
  [connection channel-id]
  (slack-request connection "groups.leave" {"channel" channel-id}))

(defn list
  "Lists private groups that the calling user has access to."
  [connection]
  (slack-request connection "groups.list"))

(defn mark
  "Sets the read cursor in a private group."
  [connection channel-id timestamp]
  (slack-request connection "groups.mark" {"channel" channel-id "ts" timestamp}))

(defn rename
  "Rename a private group."
  [connection channel-id name]
  (slack-request connection "groups.rename" {"channel" channel-id "name" name}))

(defn set-purpose
  "Sets the purpose for a private group."
  [connection channel-id purpose]
  (slack-request connection "groups.setPurpose" {"channel" channel-id "purpose" purpose}))

(defn set-topic
  "Sets the topic for a private group."
  [connection channel-id topic]
  (slack-request connection "groups.setTopic" {"channel" channel-id "topic" topic}))
