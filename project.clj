(defproject org.julienxx/clj-slack "0.8.3"
  :description "Slack REST API wrapper"
  :url "http://github.com/julienXX/clj-slack"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clj-commons/clj-http-lite "1.0.13"]
                 [cheshire/cheshire "5.11.0"]
                 [org.clojure/tools.logging "1.2.4"]]
  :deploy-repositories [["clojars"  {:sign-releases false}]])
