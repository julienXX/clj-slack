(ns clj-slack.groups
  (:use [clj-slack.core :only [slack-request]])
  (:refer-clojure :exclude [list]))

(defn create
  "Creates a private group."
  [name]
  (slack-request "groups.create" {"name" name}))

(defn create-child
  "Clones and archives a private group."
  [channel-id]
  (slack-request "groups.createChild" {"channel" channel-id}))

(defn history
  "Fetches history of messages and events from a private group."
  [channel-id]
  (slack-request "groups.history" {"channel" channel-id}))

(defn invite
  "Invites a user to a private group."
  [channel-id user-id]
  (slack-request "groups.invite" {"channel" channel-id "user" user-id}))

(defn kick
  "Removes a user from a private group."
  [channel-id user-id]
  (slack-request "groups.kick" {"channel" channel-id "user" user-id}))

(defn leave
  "Leaves a private group."
  [channel-id]
  (slack-request "groups.leave" {"channel" channel-id}))

(defn list
  "Lists private groups that the calling user has access to."
  []
  (slack-request "groups.list"))

(defn mark
  "Sets the read cursor in a private group."
  [channel-id timestamp]
  (slack-request "groups.mark" {"channel" channel-id "ts" timestamp}))

(defn rename
  "Rename a private group."
  [channel-id name]
  (slack-request "groups.rename" {"channel" channel-id "name" name}))

(defn set-purpose
  "Sets the purpose for a private group."
  [channel-id purpose]
  (slack-request "groups.setPurpose" {"channel" channel-id "purpose" purpose}))

(defn set-topic
  "Sets the topic for a private group."
  [channel-id topic]
  (slack-request "groups.setTopic" {"channel" channel-id "topic" topic}))
