(ns clj-slack.dialog
  (:require [clj-slack.core :refer [slack-post-request]]))

(defn open
  [connection dialog trigger-id]
  (slack-post-request connection "dialog.open" {"dialog" dialog "trigger_id" trigger-id}))
