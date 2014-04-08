(ns clj-slack.core
  (:require
   [org.httpkit.client :as http]
   [clojure.data.json :as json]))


(def ^:dynamic *access-token* nil)
(def ^:dynamic *api-base* "https://api.slack.com/api/")

(defn slack-request
  ([endpoint]
     (let [response (http/get (str *api-base* endpoint "?token=" *access-token*))]
       (json/read-str (:body @response))))
  ([endpoint id]
     (let [response (http/get (str *api-base* endpoint "?token=" *access-token* "&channel=" id))]
       (json/read-str (:body @response)))))

(defn auth-test []
  (slack-request "auth.test"))

(defn users-list []
  (slack-request "users.list"))

(defn groups-list []
  (slack-request "groups.list"))

(defn channels-list []
  (slack-request "channels.list"))

(defn channels-history [channel-id]
  (slack-request "channels.history" channel-id))

(defn -main []
  "I don't do a whole lot."
  (println "Hello, World!"))
