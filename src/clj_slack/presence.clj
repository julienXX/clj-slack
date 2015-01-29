(ns clj-slack.presence
  (:use [clj-slack.core :only [slack-request]]))

(defn set
  "Manually set user presence."
  [connection presence]
  (slack-request connection "presence.set" {"presence" presence}))
