(ns clj-slack.oauth
  (:require [clj-slack.core :refer [slack-request]]))

(defn access
  "Exchanges a temporary OAuth code for an API token.

  Provides client-id and client-secret using HTTP Basic auth."
  [connection client-id client-secret code redirect-uri]
  (slack-request
    (merge connection {:skip-token-validation true
                       :basic-auth [client-id client-secret]})
    "oauth.v2.access"
    {"code" code
     "redirect_uri" redirect-uri}))
