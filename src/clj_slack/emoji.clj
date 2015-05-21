(ns clj-slack.emoji
  (:require [clj-slack.core :refer [slack-request]])
  (:refer-clojure :exclude [list]))

(defn list
  "Lists custom emoji for a team."
  [connection]
  (slack-request connection "emoji.list"))
