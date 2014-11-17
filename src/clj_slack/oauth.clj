(ns clj-slack.oauth
  (:use [clj-slack.core :only [slack-request]]))

(defn access
  "Exchanges a temporary OAuth code for an API token."
  [client-id client-secret code redirect-uri]
  (slack-request "oauth.access" client-id client-secret code  redirect-uri))
