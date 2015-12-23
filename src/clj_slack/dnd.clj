(ns clj-slack.dnd
  (:require [clj-slack.core :refer [slack-request stringify-keys]]))

(defn info
  "Retrieves a user's current Do Not Disturb status."
  [connection user]
  (slack-request connection "dnd.info" {"user" user}))

(defn setSnooze
  "Turns on Do Not Disturb mode for the current user, or changes its duration."
  [connection num_minutes]
  (slack-request connection "dnd.setSnooze" {"num_minutes" (.toString num_minutes)}))

(defn endSnooze
  "Ends the current user's snooze mode immediately."
  [connection]
  (slack-request connection "dnd.endSnooze"))

(defn endDnd
  "Ends the current user's Do Not Disturb session immediately."
  [connection]
  (slack-request connection "dnd.endDnd"))

(defn teamInfo
  "Retrieves the Do Not Disturb status for users on a team."
  ([connection]
   (teamInfo connection {}))
  ([connection optionals]
   (->> optionals
        stringify-keys
        (slack-request connection "dnd.teamInfo"))))
