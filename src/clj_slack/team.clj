(ns clj-slack.team
  (:require [clj-slack.core :refer [slack-request stringify-keys]]))

(defn access-log
  "Gets the access logs for the current team.
  Optional arguments are:
  count: number of items to return per page
  page: page number of results to return"
  ([connection]
    (slack-request connection "team.accessLogs"))
  ([connection optionals]
   (->> optionals
        stringify-keys
        (slack-request connection "team.accessLogs"))))

(defn info
  "Gets information about the current team."
  [connection]
  (slack-request connection "team.info"))
