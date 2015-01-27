(ns clj-slack.core
  (:require
   [environ.core :refer [env]]
   [org.httpkit.client :as http]
   [clojure.data.json :as json])
  (:import [java.net URLEncoder]))

(def ^:dynamic api-base "https://slack.com/api/")
(def ^:dynamic access-token (str (:slack-token env)))

(defn connection
  [& {:keys [api-url token]
      :or {api-url api-base
           token access-token}}]
  {:api-url api-url :token token})

(defn send-request
  [connection params]
  (let [response (http/get (str (:api-url connection) params))]
    (json/read-str (:body @response))))

(defn make-query-string [m]
  (->> (for [[k v] m]
         (str k "=" (URLEncoder/encode v "UTF-8")))
       (interpose "&")
       (apply str)))

(defn build-params
  ([connection endpoint query-map]
   (str endpoint "?token=" (:token connection) "&" (make-query-string query-map))))

(defn slack-request
  ([& {:keys [connection endpoint query]
       :or {connection connection
            query-map {}}}]
   (let [params (build-params connection endpoint query)]
     (send-request connection params))))

(defmacro with-api-url [new-url & body]
  `(binding [api-base ~new-url]
     ~@body))

(defmacro with-access-token [new-token & body]
  `(binding [access-token ~new-token]
     ~@body))
