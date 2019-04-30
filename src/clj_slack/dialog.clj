(ns clj-slack.dialog
  (:require [clj-slack.core :refer [slack-post-request]]))

(defn open
  "Opens a dialog for the user that caused the trigger trigger-id.

  - dialog: a json encoded string of a dialog
  - trigger-id: the trigger-id of the event that the dialog will open for

  See: https://api.slack.com/methods/dialog.open
  "
  [connection dialog trigger-id]
  (slack-post-request connection "dialog.open" {"dialog" dialog "trigger_id" trigger-id}))
