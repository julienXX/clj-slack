(ns clj-slack.views
  (:require [clj-slack.core :refer [slack-post-request]]))

(defn open
  "Opens a view for the user that caused the trigger trigger-id.

  - view: a json encoded string of a view
  - trigger-id: the trigger-id of the event that the view will open for

  See: https://api.slack.com/methods/views.open
  "
  [connection view trigger-id]
  (slack-post-request connection "views.open" {"view" view "trigger_id" trigger-id}))
