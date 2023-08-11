(defproject org.julienxx/clj-slack "0.8.1"
  :description "Slack REST API wrapper"
  :url "http://github.com/julienXX/clj-slack"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-http "3.12.3"]
                 [org.clojure/data.json "2.4.0"]
                 [org.clojure/tools.logging "1.2.4"]]
  :deploy-repositories [["clojars"  {:sign-releases false}]])
