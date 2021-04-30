(defproject org.julienxx/clj-slack "0.7.0"
  :description "Slack REST API wrapper"
  :url "http://github.com/julienXX/clj-slack"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [clj-http "3.12.1"]
                 [org.clojure/data.json "2.2.2"]
                 [org.clojure/tools.logging "1.1.0"]]
  :deploy-repositories [["clojars"  {:sign-releases false}]])
