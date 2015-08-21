(ns clj-slack.oauth
  (:require [clj-slack.core :refer [slack-request]]))

(defn access
  "Exchanges a temporary OAuth code for an API token."
  [connection client-id client-secret code redirect-uri]
  (slack-request
    (merge connection {:skip-token-validation true})
    "oauth.access"
    {"client_id" client-id
     "client_secret" client-secret
     "code" code
     "redirect_uri" redirect-uri}))
