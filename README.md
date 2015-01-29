# clj-slack

clj-slack is a Clojure library to talk to the [Slack](http://slack.com) REST API. It supports almost the entire Slack API.

![Clojars Project](http://clojars.org/org.julienxx/clj-slack/latest-version.svg)

## Basic Usage

This is on clojars, of course. Just add ```[clj-slack "0.1.2"]``` to your ```:dependencies``` in your project.clj file.

Get your access token [here](https://api.slack.com/web).

Your need to create a connection map like ```{:api-url "https://slack.com/api" :token "YOUR TOKEN"}``` and pass it as the first argument of every functions in clj-slack. Of course you can change api-url for debugging or testing purposes.

Example in a REPL:
```clojure
(require 'clj-slack.users)
(def connection {:api-url "https://slack.com/api" :token "YOUR TOKEN"})
(clj-slack.users/list connection)
```
will give you the list of your team users for example.

clj-slack will throw an Exception if the map you're trying to use is not valid.

## To Do
- [ ] Proper documentation
- [ ] Add tests
- [ ] Update docstrings with params
- [ ] Handle optional params
- [ ] File upload

## License

Copyright (C) 2014-2015 Julien Blanchard

Distributed under the Eclipse Public License, the same as Clojure.
