(ns clj-slack.emoji
  (:use [clj-slack.core :only [slack-request]])
  (:refer-clojure :exclude [list]))

(defn list
  "Lists custom emoji for a team."
  [connection]
  (slack-request connection "emoji.list"))
