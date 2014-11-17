(ns clj-slack.groups
  (:use [clj-slack.core :only [slack-request]])
  (:refer-clojure :exclude [list]))

(defn create
  "Creates a private group."
  [name]
  (slack-request "groups.create" name))

(defn create-child
  "Clones and archives a private group."
  [channel-id]
  (slack-request "groups.createChild" channel-id))

(defn history
  "Fetches history of messages and events from a private group."
  [channel-id]
  (slack-request "groups.history" channel-id))

(defn invite
  "Invites a user to a private group."
  [channel-id user-id]
  (slack-request "groups.invite" channel-id user-id))

(defn kick
  "Removes a user from a private group."
  [channel-id user-id]
  (slack-request "groups.kick" channel-id user-id))

(defn leave
  "Leaves a private group."
  [channel-id]
  (slack-request "groups.leave" channel-id))

(defn list
  "Lists private groups that the calling user has access to."
  []
  (slack-request "groups.list"))

(defn mark
  "Sets the read cursor in a private group."
  [channel-id timestamp]
  (slack-request "groups.mark" channel-id timestamp))

(defn rename
  "Rename a private group."
  [channel-id name]
  (slack-request "groups.rename" channel-id name))

(defn set-purpose
  "Sets the purpose for a private group."
  [channel-id purpose]
  (slack-request "groups.setPurpose" channel-id purpose))

(defn set-topic
  "Sets the topic for a private group."
  [channel-id topic]
  (slack-request "groups.setTopic" channel-id topic))
