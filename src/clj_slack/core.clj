(ns clj-slack.core
  (:require
   [environ.core :refer [env]]
   [org.httpkit.client :as http]
   [clojure.data.json :as json]))

(def ^:dynamic api-base "https://slack.com/api/")
(def ^:dynamic access-token (str (:slack-token env)))

(defn send-request
  [params]
  (let [response (http/get (str api-base params))]
    (json/read-str (:body @response))))

(defn make-query-string [m]
  (->> (for [[k v] m]
         (str k "=" v))
       (interpose "&")
       (apply str)))

(defn build-params
  ([endpoint query-map]
     (str endpoint "?token=" access-token "&" (make-query-string query-map))))

(defn slack-request
  ([endpoint]
     (slack-request endpoint {}))
  ([endpoint query-map]
     (let [params (build-params endpoint query-map)]
       (send-request params))))

(defmacro with-api-url [new-url & body]
 `(binding [api-base ~new-url]
    ~@body))

(defmacro with-access-token [new-token & body]
 `(binding [access-token ~new-token]
    ~@body))
