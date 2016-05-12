(ns clj-slack.stars
  (:require [clj-slack.core :refer [slack-request stringify-keys]])
  (:refer-clojure :exclude [list remove]))

(defn add
  "This method adds a star to an item on behalf of the authenticated user.
  One of file, file_comment, channel, or the combination of channel and timestamp must be specified.
  Optional arguments are:
  - file: file to add star to
  - file_comment: file comment to add star to
  - channel: channel to add star to, or channel where the message to add star to was posted (used with timestamp)
  - timestamp: used with channel, see above"
  [connection optionals]
  (->> optionals
       stringify-keys
       (slack-request connection "stars.add")))

(defn list
  "Lists stars for a user.
  Optional arguments are:
  - user: show stars by a user
  - count: number of items to return per page
  - page: page number of results to return"
  ([connection]
   (list connection {}))
  ([connection optionals]
   (->> optionals
        stringify-keys
        (slack-request connection "stars.list"))))

(defn remove
  "This method removes a star from an item on behalf of the authenticated user.
  One of file, file_comment, channel, or the combination of channel and timestamp must be specified.
  Optional arguments are:
  - file: file to remove star from
  - file_comment: file comment to remove star from
  - channel: channel to remove star from, or channel where the message to remove star from was posted (used with timestamp)
  - timestamp: used with channel, see above"
  [connection optionals]
  (->> optionals
       stringify-keys
       (slack-request connection "stars.remove")))
