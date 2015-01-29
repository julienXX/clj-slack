(ns clj-slack.core
  (:require
   [org.httpkit.client :as http]
   [clojure.data.json :as json])
  (:import [java.net URLEncoder]))


(defn verify
  "Accept a map containing api-url, token"
  [connection]
  (if (or (empty? (connection :api-url)) (empty? (connection :token)))
    (throw (Exception. "Please check your connection, it needs to be a map with an api-url and your token."))
    connection))

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
