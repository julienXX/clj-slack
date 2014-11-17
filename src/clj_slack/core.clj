(ns clj-slack.core
  (:require
   [environ.core :refer [env]]
   [org.httpkit.client :as http]
   [clojure.data.json :as json]))

(def api-base "https://slack.com/api/")
(def access-token (str (:slack-token env)))

(defn send-request
  [params]
  (let [response (http/get (str api-base params))]
    (json/read-str (:body @response))))

(defn make-query-string [m]
  (->> (for [[k v] m]
         (str "&" k "=" v))
       (interpose "&")
       (apply str)))

(defn build-params
  ([endpoint query-map]
     (str endpoint "?token=" access-token (make-query-string query-map))))

(defn slack-request
  ([endpoint]
     (slack-request endpoint {}))
  ([endpoint query-map]
     (let [params (build-params endpoint query-map)]
       (send-request params))))
