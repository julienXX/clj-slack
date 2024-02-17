(ns clj-slack.core
  (:require
   [clj-http.lite.client :as http]
   [cheshire.core :as json]
   [clojure.tools.logging :as log])
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
  (when (not (contains? connection :skip-token-validation))
    (verify-token connection))
  connection)

(defn- send-request
  "Sends a GET http request with formatted params.
  Optional request options can be specified which will be passed to `clj-http` without any changes.
  Can be useful to specify timeouts, etc."
  [url token params & [opts]]
  (let [full-url (str url params)
        headers {"Content-Type" "application/x-www-form-urlencoded"
                 "Authorization" (str "Bearer " token)}
        response (http/get full-url (merge {:headers headers} opts))]
    (if-let [body (:body response)]
      (json/parse-string body true)
      (log/error "Error from Slack API:" (:error response)))))

(defn- send-post-request
  "Sends a POST http request with formatted params.
  Optional request options can be specified which will be passed to `clj-http` without any changes.
  Can be useful to specify timeouts, etc."
  [url token post-params & [opts]]
  (let [headers {"Content-Type" "application/json; charset=utf-8"
                 "Authorization" (str "Bearer " token)}
        response (http/post url (merge {:body (json/generate-string post-params)
                                        :headers headers}
                                       opts))]
    (json/parse-string (:body response) true)))

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
   (str "/" endpoint "?" (make-query-string query-map))))

(defn stringify-keys
  "Creates a new map whose keys are all strings."
  [m]
  (into {} (for [[k v] m]
             (if (keyword? k)
               [(name k) v]
               [(str k) v]))))

(defn- request-options
  "Extracts request options from slack connection map.
  Provides sensible defaults for timeouts."
  [connection]
  (let [default-options {:conn-timeout 60000
                         :socket-timeout 60000}]
    (merge default-options
           (dissoc connection :api-url :token))))

(defn slack-request
  ([connection endpoint]
   (slack-request connection endpoint {}))
  ([{:keys [token] :as connection} endpoint query]
   (let [url (-> connection verify :api-url)
         params (build-params connection endpoint query)]
     (send-request url token params (request-options connection)))))

(defn slack-post-request
  [{:keys [token] :as connection} endpoint post-params]
  (let [api-url (-> connection verify :api-url)
        url (str api-url "/" endpoint)]
    (send-post-request url token post-params (request-options connection))))
