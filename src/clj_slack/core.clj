(ns clj-slack.core
  (:require [http.async.client :as http]))

(def ^:dynamic *access-token* nil)
(def ^:dynamic *api-base* "https://api.slack.com/")

(defn -main []
  "I don't do a whole lot."
  (println "Hello, World!"))
