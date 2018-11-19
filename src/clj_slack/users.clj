(ns clj-slack.users
  (:require [clj-slack.core :refer [slack-request]])
  (:refer-clojure :exclude [list]))

(defn conversations
  "Lists all channels in a Slack team.
  Optional arguments are:
  - cursor: Paginate through collections of data by setting the cursor parameter to a next_cursor attribute.
  - exclude_archived: Set to true to exclude archived channels from the list.
  - limit: The maximum number of items to return.
  - types: Mix and match channel types by providing a comma-separated list of any combination of public_channel, private_channel, mpim, im
  - user: Browse conversations by a specific user ID's membership.
  "
  ([connection]
   (conversations connection {}))
  ([connection optionals]
   (->> optionals
        stringify-keys
        (slack-request connection "users.conversations"))))

(defn get-presence
  "Gets user presence information."
  [connection user-id]
  (slack-request connection "users.getPresence" {"user" user-id}))

(defn info
  "Gets information about a user."
  [connection user-id]
  (slack-request connection "users.info" {"user" user-id}))

(defn list
  "Lists all users in a Slack team."
  [connection]
  (slack-request connection "users.list"))

(defn set-active
  "Marks a user as active."
  [connection]
  (slack-request connection "users.setActive"))

(defn set-presence
  "Manually sets user presence."
  [connection user-id presence]
  (slack-request connection "users.setPresence" {"user" user-id "presence" presence}))
