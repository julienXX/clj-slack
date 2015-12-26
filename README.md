# clj-slack

clj-slack is a Clojure library to talk to the [Slack](http://slack.com) REST API. It supports almost the entire Slack API.

![Build Status](https://travis-ci.org/julienXX/clj-slack.svg?branch=master)

## Documentation

Slack API methods are described [here](https://api.slack.com/methods).

clj-slack documentation is available [here](http://julienblanchard.com/clj-slack/).

## Usage

This is on [Clojars](https://clojars.org/org.julienxx/clj-slack) of course. Just add ```[org.julienxx/clj-slack "0.5.2"]``` to your ```:dependencies``` in your project.clj file.

Get your access token [here](https://api.slack.com/web).

Your need to create a connection map like ```{:api-url "https://slack.com/api" :token "YOUR TOKEN"}``` and pass it as the first argument of every functions in clj-slack. Of course you can change api-url for debugging or testing purposes.

clj-slack will throw an Exception if the connection map you're trying to use is not valid.

Example:
```clojure
(require 'clj-slack.users)
(def connection {:api-url "https://slack.com/api" :token "YOUR TOKEN"})
(clj-slack.users/list connection)
```

You can use optional params described in [Slack API](https://api.slack.com/methods) by passing them through a map.
```clojure
(require 'clj-slack.stars)
(def connection {:api-url "https://slack.com/api" :token "YOUR TOKEN"})
(clj-slack.stars/list connection {:count "2" :page "3"})
```

Uploading a file:
```clojure
(require 'clj-slack.files)
(def connection {:api-url "https://slack.com/api" :token "YOUR TOKEN"})
(clj-slack.files/upload connection (clojure.java.io/input-stream "/path/to/file/file.ext") {:channels "CHANNEL_ID", :title "This is a file.})
```

## To Do
- Add tests

## License

Copyright (C) 2014-2015 Julien Blanchard

Distributed under the Eclipse Public License, the same as Clojure.
