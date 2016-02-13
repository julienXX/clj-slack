(ns clj-slack.usergroups
  (:require [clj-slack.core :refer [slack-request]])
  (:refer-clojure :exclude [list update]))

(defn create
  "Create a user group"
  [connection]
  (slack-request connection "usergroups.create"))

(defn disable
  "Disable an existing user group"
  [connection]
  (slack-request connection "usergroups.disable"))

(defn enable
  "Enable a user group"
  [connection]
  (slack-request connection "usergroups.enable"))

(defn list
  "List all user groups for a team"
  [connection]
  (slack-request connection "usergroups.list"))

(defn update
  "Update an existing user group"
  [connection]
  (slack-request connection "usergroups.update"))
