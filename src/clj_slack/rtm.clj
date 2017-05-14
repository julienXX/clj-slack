(ns clj-slack.rtm
  (:require [clj-slack.core :refer [slack-request]]))

(defn start
  "Starts a Real Time Messaging session."
  [connection]
  (slack-request connection "rtm.start"))

(defn connect
  "Starts a Real Time Messaging session. Recommended over start:
  https://api.slack.com/rtm"
  [connection]
  (slack-request connection "rtm.connect"))
