(ns clj-slack.search
  (:use [clj-slack.core :only [slack-request]]))

(defn all
  "Searches for messages and files matching a query."
  [connection query]
  (slack-request connection "search.all" {"query" query}))

(defn files
  "Searches for files matching a query."
  [connection query]
  (slack-request connection "search.files" {"query" query}))

(defn messages
  "Searches for messages matching a query."
  [connection query]
  (slack-request connection "search.messages" {"query" query}))
