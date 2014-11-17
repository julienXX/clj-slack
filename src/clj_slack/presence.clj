(ns clj-slack.presence
  (:use [clj-slack.core :only [slack-request]]))

(defn set
  "Manually set user presence."
  [presence]
  (slack-request "presence.set" presence))
