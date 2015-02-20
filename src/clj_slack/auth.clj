(ns clj-slack.auth
  (:use [clj-slack.core :only [slack-request]])
  (:refer-clojure :exclude [test]))

 (defn test
   "Checks authentication & identity."
   [connection]
   (slack-request connection "auth.test"))
