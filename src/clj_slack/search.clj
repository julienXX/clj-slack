(ns clj-slack.search
  (:use [clj-slack.core :only [slack-request]]))

(defn all
  "Searches for messages and files matching a query."
  [query]
  (slack-request "search.all" query))

(defn files
  "Searches for files matching a query."
  [query]
  (slack-request "search.files" query))

(defn messages
  "Searches for messages matching a query."
  [query]
  (slack-request "search.messages" query))
