# clj-slack

A Clojure library designed to wrap [Slack](http://slack.com) REST API.

## Usage

Declare dependency:

``` clojure
(defproject your-project "1.0.0-SNAPSHOT"
  :description "Your project description"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [clj-slack "0.1.0"]])
```

Require:

``` clojure
(ns sample (:require [clj-slack :as slack]))
```

## License

Copyright © 2014 Julien Blanchard

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
