(ns clj-slack.core
  (:require
   [org.httpkit.client :as http]
   [clojure.data.json :as json])
  (:import [java.net URLEncoder]))


(defn verify-api-url
  [connection]
  (assert
   (and (string? (:api-url connection))
        (and (not (empty? (:api-url connection)))
             (not (nil? (re-find #"^https?:\/\/" (:api-url connection))))))
   (str "clj-slack: API URL is not valid. :api-url has to be a valid URL (https://slack.com/api usually), but is " (pr-str (:api-url connection)))))

(defn verify-token
  [connection]
  (assert
   (and (string? (:token connection))
        (not (empty? (:token connection))))
   (str "clj-slack: Access token is not valid. :token has to be a non-empty string, but is " (pr-str (:token connection)))))

(defn verify
  "Checks the connection map"
  [connection]
  (verify-api-url connection)
  (verify-token connection)
  connection)

(defn- send-request
  "Sends the http request with formatted params"
  [connection params]
  (let [response (http/get (str (:api-url (verify connection)) params))]
    (json/read-str (:body @response) :key-fn clojure.core/keyword)))

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
