# clj-slack

clj-slack is a Clojure library to talk to the [Slack](http://slack.com) REST API. It supports almost the entire Slack API.

![Clojars Project](http://clojars.org/org.julienxx/clj-slack/latest-version.svg)

## Usage

This is on clojars, of course. Just add ```[clj-slack "0.1.0"]``` to your ```:dependencies``` in your project.clj file.

Add a .lein-env at the root of your project with something like:

```clojure
{:slack-token "YOUR_SLACK_API_TOKEN"}
```

```clojure
λ lein repl
nREPL server started on port 53171 on host 127.0.0.1
REPL-y 0.3.0
Clojure 1.6.0
    Docs: (doc function-name-here)
          (find-doc "part-of-name-here")
  Source: (source function-name-here)
 Javadoc: (javadoc java-object-or-class-here)
    Exit: Control+D or (exit) or (quit)
 Results: Stored in vars *1, *2, *3, an exception in *e

user=> (require 'clj-slack.users)
nil
user=> (clj-slack.users/list)
{...}
```

## To Do
- [ ] Add tests
- [ ] Update docstrings with params
- [ ] Handle optional params
- [ ] File upload

## License

Copyright (C) 2014 Julien Blanchard

Distributed under the Eclipse Public License, the same as Clojure.


[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/julienXX/clj-slack/trend.png)](https://bitdeli.com/free "Bitdeli Badge")

