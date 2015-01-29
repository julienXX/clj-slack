(ns clj-slack.core
  (:require
   [org.httpkit.client :as http]
   [clojure.data.json :as json]
   [schema.core :as s])
  (:import [java.net URLEncoder]))

(def Connection
  "A schema for a Slack API connection."
  {:api-url s/Str :token s/Str})

(defn verify
  "Checks the connection map."
  [connection]
  (s/validate Connection connection))

(defn send-request
  [connection params]
  (let [response (http/get (str (:api-url (verify connection)) params))]
    (json/read-str (:body @response))))

(defn make-query-string [m]
  (->> (for [[k v] m]
         (str k "=" (URLEncoder/encode v "UTF-8")))
       (interpose "&")
       (apply str)))

(defn build-params
  ([connection endpoint query-map]
   (str "/" endpoint "?token=" (:token (verify connection)) "&" (make-query-string query-map))))

(defn slack-request
  ([connection endpoint]
   (let [params (build-params connection endpoint {})]
     (send-request connection params)))
  ([connection endpoint query]
   (let [params (build-params connection endpoint query)]
     (send-request connection params))))
