(ns clj-slack.stars
  (:use [clj-slack.core :only [slack-request stringify-keys]])
  (:refer-clojure :exclude [list]))

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
