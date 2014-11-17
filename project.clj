(defproject clj-slack "0.1.0"
  :description "Slack REST API wrapper"
  :url "http://github.com/julienXX/clj-slack"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main clj-slack.core
  :profiles {:uberjar {:aot [campfire.core]}}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [http-kit "2.1.16"]
                 [org.clojure/data.json "0.2.5"]])
