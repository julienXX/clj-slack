(ns clj-slack.mpim
  (:require [clj-slack.core :refer [slack-request stringify-keys]])
  (:refer-clojure :exclude [list]))

(defn close
  "Closes a multiparty direct message channel."
  [connection channel-id]
  (slack-request connection "mpin.close" {"channel" channel-id}))

(defn history
  "Fetches history of messages and events from a multiparty direct message.`
  Optional arguments are:
  - latest: end of time range of messages to include in results.
  - oldest: start of time range of messages to include in results.
  - inclusive: include messages with latest or oldest timestamp in results.
  - count: number of messages to return, between 1 and 1000.
  - unread: include unread_count_display in the output?"
  ([connection channel-id]
   (history connection channel-id {}))
  ([connection channel-id optionals]
   (->> optionals
        stringify-keys
        (merge {"channel" channel-id})
        (slack-request connection "mpin.history"))))

(defn list
  "Lists multiparty direct message channels for the calling user."
  [connection]
  (slack-request connection "mpin.list"))

(defn mark
  "Sets the read cursor in a multiparty direct message channel."
  [connection channel-id timestamp]
  (slack-request connection "mpin.mark" {"channel" channel-id "ts" timestamp}))

(defn open
  "This method opens a multiparty direct message."
  [connection user-id]
  (slack-request connection "mpin.open" {"user" user-id}))
