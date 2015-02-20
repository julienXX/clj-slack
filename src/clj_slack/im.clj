(ns clj-slack.im
  (:use [clj-slack.core :only [slack-request stringify-keys]])
  (:refer-clojure :exclude [list]))

(defn close
  "Closes a direct message channel."
  [connection channel-id]
  (slack-request connection "im.close" {"channel" channel-id}))

(defn history
  "Fetches history of messages and events from direct message channel.
  Optional arguments are:
  - latest: end of time range of messages to include in results
  - oldest: start of time range of messages to include in results
  - inclusive: include messages with latest or oldest timestamp in results
  - count: number of messages to return"
  ([connection channel-id]
   (history connection channel-id {}))
  ([connection channel-id optionals]
   (->> optionals
        stringify-keys
        (merge {"channel" channel-id})
        (slack-request connection "im.history"))))

(defn list
  "Lists direct message channels for the calling user."
  [connection]
  (slack-request connection "im.list"))

(defn mark
  "Sets the read cursor in a direct message channel."
  [connection channel-id timestamp]
  (slack-request connection "im.mark" {"channel" channel-id "ts" timestamp}))

(defn open
  "Opens a direct message channel."
  [connection user-id]
  (slack-request connection "im.open" {"user" user-id}))
