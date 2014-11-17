(ns clj-slack.core
  (:require
   [environ.core :refer [env]]
   [org.httpkit.client :as http]
   [clojure.data.json :as json]))

(def api-base "https://api.slack.com/api/")
(def access-token (str (:slack-token env)))

(defn send-request
  [params]
  (let [response (http/get (str api-base params))]
    (json/read-str (:body @response))))

(defn build-params
  ([endpoint]
     (str endpoint "?token=" access-token))
  ([endpoint channel-id]
     (str endpoint "?token=" access-token "&channel=" channel-id)))

(defn slack-request
  ([endpoint]
     (let [params (build-params endpoint)]
       (send-request params)))
  ([endpoint id]
     (let [params (build-params endpoint id)]
       (send-request params))))
