(ns clj-slack.reminders
  (:require [clj-slack.core :refer [slack-request stringify-keys]])
  (:refer-clojure :exclude [list]))

(defn add
  "This method creates a reminder.
  Optional arguments are:
  - user: The user who will receive the reminder. If no user is specified, the reminder will go to user who created it."
  ([connection text time]
   (add connection text time {}))
  ([connection text time optionals]
   (->> optionals
        stringify-keys
        (merge {"text" text
                "time" time})
        (slack-request connection "reminders.add"))))

(defn complete
  "This method completes a reminder."
  [connection reminder]
  (slack-request connection "reminders.complete" {"reminder" reminder}))

(defn delete
  "This method deletes a reminder."
  [connection reminder]
  (slack-request connection "reminders.delete" {"reminder" reminder}))

(defn info
  "This method returns information about a reminder."
  [connection reminder]
  (slack-request connection "reminders.info" {"reminder" reminder}))

(defn list
  "This method lists all reminders created by or for a given user."
  [connection]
  (slack-request connection "reminders.list"))




