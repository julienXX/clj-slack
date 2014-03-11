(ns clj-slack.core
  (:require [org.httpkit.client :as http]))

(def ^:dynamic *access-token* nil)
(def ^:dynamic *api-base* "https://api.slack.com/api/")

(defn slack-request [endpoint]
  (println "Making a request!")
  (let [response (http/get (str *api-base* endpoint))]
    ;; Other keys :headers :body :error :opts
    (println "response's status: " (:status @response1))))

(defn users-list []
  (slack-request "users.list"))

(defn -main []
  "I don't do a whole lot."
  (println "Hello, World!"))
