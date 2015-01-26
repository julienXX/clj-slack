# clj-slack

clj-slack is a Clojure library to talk to the [Slack](http://slack.com) REST API. It supports almost the entire Slack API.

![Clojars Project](http://clojars.org/org.julienxx/clj-slack/latest-version.svg)

## Basic Usage

This is on clojars, of course. Just add ```[clj-slack "0.1.1"]``` to your ```:dependencies``` in your project.clj file.

Get your access token [here](https://api.slack.com/web).

If you intend to use clj-slack with a single organization, add a .lein-env at the root of your project with something like:

```clojure
{:slack-token "YOUR_SLACK_API_TOKEN"}
```

In a REPL:
```clojure
(require 'clj-slack.users)
(clj-slack.users/list)
```
will give you the list of your team users for example.

## Advanced Usage

Two macros are available:

* with-access-token allows you to use an arbitrary token when you need to query multiple organizations for example.
```clojure
(require 'clj-slack.users)
(with-access-token "another token" (clj-slack.users/list))
```

* with-api-url allows you to use another URL than Slack's API URL for debugging purposes.
```clojure
(require 'clj-slack.users)
(with-api-url "http://localhost:8080/" (clj-slack.users/list))
```

## To Do
- [ ] Proper documentation
- [ ] Add tests
- [ ] Update docstrings with params
- [ ] Handle optional params
- [ ] File upload

## License

Copyright (C) 2014 Julien Blanchard

Distributed under the Eclipse Public License, the same as Clojure.
