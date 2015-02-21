(ns clj-slack.api
  (:use [clj-slack.core :only [slack-request]])
  (:refer-clojure :exclude [test]))

(defn test
  "Helps you test your calling code.
  Optional arguments are:
  - error: error response to return
  - foo: example property to return"
  ([connection]
     (slack-request connection "auth.test"))
  ([connection optionals]
     (->> optionals
          stringify-keys
          (slack-request connection "auth.test"))))
