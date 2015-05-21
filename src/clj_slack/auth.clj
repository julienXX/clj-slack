(ns clj-slack.auth
  (:require [clj-slack.core :refer [slack-request]])
  (:refer-clojure :exclude [test]))

(defn test
  "Checks authentication & identity."
  [connection]
  (slack-request connection "auth.test"))
