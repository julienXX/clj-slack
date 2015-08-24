(ns clj-slack.reactions
  (:require [clj-slack.core :refer [slack-request stringify-keys]]))

(defn add
  "Adds a reaction to an item.
  This API adds reaction(emoji) to an item.
  One of file, file_comment, or the combination of channel and timestamp must be specified.
  Optional arguments are:
  - file: file to add reaction to
  - file_comment: file comment to add reaction to
  - channel: channel where the message to add reaction to was posted
  - timestamp: timestamp of the message to add reaction to"
  [connection name optionals]
  (->> optionals
       stringify-keys
       (merge {"name" name})
       (slack-request connection "reactions.add")))
