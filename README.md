# clj-slack

clj-slack is a Clojure library to talk to the [Slack](http://slack.com) REST API. It supports almost the entire Slack API.

## Documentation

Slack API methods are described [here](https://api.slack.com/methods).

clj-slack documentation is available [here](http://julienblanchard.com/clj-slack/).

## Usage

This is on [Clojars](https://clojars.org/org.julienxx/clj-slack) of course. Just add ```[clj-slack "0.3.0"]``` to your ```:dependencies``` in your project.clj file.

Get your access token [here](https://api.slack.com/web).

Your need to create a connection map like ```{:api-url "https://slack.com/api" :token "YOUR TOKEN"}``` and pass it as the first argument of every functions in clj-slack. Of course you can change api-url for debugging or testing purposes.

Example in a REPL:
```clojure
(require 'clj-slack.users)
(def connection {:api-url "https://slack.com/api" :token "YOUR TOKEN"})
(clj-slack.users/list connection)
```
will give you the list of your team users.

clj-slack will throw an Exception if the map you're trying to use is not valid.

## To Do
- [ ] Add tests
- [ ] Update docstrings with params
- [ ] Handle optional params
- [ ] File upload

## License

Copyright (C) 2014-2015 Julien Blanchard

Distributed under the Eclipse Public License, the same as Clojure.
