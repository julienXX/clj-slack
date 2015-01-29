(ns clj-slack.core
  (:require
   [org.httpkit.client :as http]
   [clojure.data.json :as json]
   [schema.core :as s])
  (:import [java.net URLEncoder]))

(def Connection
  "A schema for a Slack API connection"
  {:api-url s/Str :token s/Str})

(defn- verify
  "Checks the connection map"
  [connection]
  (s/validate Connection connection))

(defn- send-request
  "Sends the http request with formatted params"
  [connection params]
  (let [response (http/get (str (:api-url (verify connection)) params))]
    (json/read-str (:body @response))))

(defn- make-query-string
  "Transforms a map into url params"
  [m]
  (->> (for [[k v] m]
         (str k "=" (URLEncoder/encode v "UTF-8")))
       (interpose "&")
       (apply str)))

(defn- build-params
  "Builds the full URL (endpoint + params)"
  ([connection endpoint query-map]
   (str "/" endpoint "?token=" (:token (verify connection)) "&" (make-query-string query-map))))

(defn slack-request
  ([connection endpoint]
   (slack-request connection endpoint {}))
  ([connection endpoint query]
   (let [params (build-params connection endpoint query)]
     (send-request connection params))))
