(ns clj-slack.core
  (:require
   [org.httpkit.client :as http]
   [clojure.data.json :as json]))


(def ^:dynamic *access-token* nil)
(def ^:dynamic *api-base* "https://api.slack.com/api/")

(defn slack-request [endpoint]
  (let [response (http/get (str *api-base* endpoint "?token=" *access-token*))]
    (json/read-str (:body @response))))

(defn auth-test []
  (slack-request "auth.test"))

(defn users-list []
  (slack-request "users.list"))

(defn groups-list []
  (slack-request "groups.list"))

(defn -main []
  "I don't do a whole lot."
  (println "Hello, World!"))
