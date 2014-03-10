(ns clj-slack.core
  (:require [http.async.client :as http]))

(def ^:dynamic *access-token* nil)
(def ^:dynamic *api-base* "https://api.slack.com/api/")

(defn slack-request [endpoint]
  (println "Making a request!")
  (with-open [client (http/create-client)]
    (let [response (http/GET client (str *api-base* endpoint))]
      (-> response
          http/await
          http/string))))

(defn users-list []
  (slack-request "users.list"))

(defn -main []
  "I don't do a whole lot."
  (println "Hello, World!"))
