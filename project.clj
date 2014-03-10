(defproject clj-slack "0.1.0"
  :description "Slack REST API wrapper"
  :url "http://github.com/julienXX/clj-slack"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main clj-slack.core
  :profiles {:uberjar {:aot [campfire.core]}}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [http.async.client "0.5.2"]])
