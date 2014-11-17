(ns clj-slack.files
  (:use [clj-slack.core :only [slack-request]])
  (:refer-clojure :exclude [list]))

(defn info
  "Gets information about a team file."
  [file-id]
  (slack-request "files.info" file-id))

(defn list
  "Lists & filters team files."
  []
  (slack-request "files.list"))
