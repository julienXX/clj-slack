(ns clj-slack.team
  (:require [clj-slack.core :refer [slack-request stringify-keys]]))

(defn access-log
  "Gets the access logs for the current team.
  Optional arguments are:
  - count: number of items to return per page
  - page: page number of results to return"
  ([connection]
   (access-log connection {}))
  ([connection optionals]
   (->> optionals
        stringify-keys
        (slack-request connection "team.accessLogs"))))

(defn info
  "Gets information about the current team."
  [connection]
  (slack-request connection "team.info"))

(defn integration-log
  "This method lists the integration activity logs for a team,
  including when integrations are added, modified and removed.
  This method can only be called by Admins."
  ([connection]
   (integration-log connection {}))
  ([connection optionals]
   (->> optionals
        stringify-keys
        (slack-request connection "team.integrationLogs"))))

