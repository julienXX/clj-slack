(ns clj-slack.bots
  (:require [clj-slack.core :refer [slack-request]]))

(defn info
  "Gets information about a bot."
  [connection bot-id]
  (slack-request connection "bots.info" {"bot" bot-id}))

