(ns clj-slack.im
  (:use [clj-slack.core :only [slack-request]])
  (:refer-clojure :exclude [list]))

(defn history
  "Fetches history of messages and events from direct message channel."
  [channel-id]
  (slack-request "im.history" {"channel" channel-id}))

(defn list
  "Lists direct message channels for the calling user."
  []
  (slack-request "im.list"))

(defn mark
  "Sets the read cursor in a direct message channel."
  [channel-id timestamp]
  (slack-request "im.mark" {"channel" channel-id "ts" timestamp}))
