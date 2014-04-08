(ns clj-slack.core
  (:require
   [org.httpkit.client :as http]
   [clojure.data.json :as json]))


(def ^:dynamic *access-token* nil)
(def ^:dynamic *api-base* "https://api.slack.com/api/")

(defn send-request [params]
  (let [response (http/get (str *api-base* params))]
    (json/read-str (:body @response))))

(defn build-params
  ([endpoint] (str endpoint "?token=" *access-token*))
  ([endpoint channel-id] (str endpoint "?token=" *access-token* "&channel=" channel-id)))

(defn slack-request
  ([endpoint]
     (let [params (build-params endpoint)]
       (send-request params)))
  ([endpoint id]
     (let [params (build-params endpoint id)]
       (send-request params))))

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
