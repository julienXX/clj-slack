(ns clj-slack.rtm
  (:use [clj-slack.core :only [slack-request]]))

(defn start
  "Starts a Real Time Messaging session."
  [connection]
  (slack-request connection "rtm.start"))
