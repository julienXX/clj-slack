(ns clj-slack.files-test
  (:require [clojure.test :refer :all]
            [clj-slack.files :refer :all])
  (:refer-clojure :exclude [list]))

(def connection {:api-url "https://slack.com/api" :token (System/getenv "TOKEN")})

(deftest file-upload
  (testing "Uploading a file"
    (is (= true (:ok (clj-slack.files/upload connection
                                             (clojure.java.io/input-stream "test/support/clojure.png")
                                             {:channels "C03PHJ58Z"}))))))
