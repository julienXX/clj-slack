(ns clj-slack.rtm
  (:require [clj-slack.core :refer [slack-request]]))

(defn start
  "Starts a Real Time Messaging session."
  [connection]
  (slack-request connection "rtm.start"))
