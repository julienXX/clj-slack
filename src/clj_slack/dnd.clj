(ns clj-slack.dnd
  (:require [clj-slack.core :refer [slack-request stringify-keys]]))

(defn info
  "Retrieves a user's current Do Not Disturb status."
  [connection user]
  (slack-request connection "dnd.info" {"user" user}))

(defn set-snooze
  "Turns on Do Not Disturb mode for the current user, or changes its duration."
  [connection num_minutes]
  (slack-request connection "dnd.setSnooze" {"num_minutes" (.toString num_minutes)}))

(defn end-snooze
  "Ends the current user's snooze mode immediately."
  [connection]
  (slack-request connection "dnd.endSnooze"))

(defn end-dnd
  "Ends the current user's Do Not Disturb session immediately."
  [connection]
  (slack-request connection "dnd.endDnd"))

(defn team-info
  "Retrieves the Do Not Disturb status for users on a team."
  ([connection]
   (team-info connection {}))
  ([connection optionals]
   (->> optionals
        stringify-keys
        (slack-request connection "dnd.teamInfo"))))
