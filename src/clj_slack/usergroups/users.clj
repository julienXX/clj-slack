(ns clj-slack.usergroups.users
  (:require clojure.string
            [clj-slack.core :refer [slack-request stringify-keys]])
  (:refer-clojure :exclude [list update]))

(defn list
  "List all users in a user group
  Optional argument:
  - include_disabled: Allow results that involve disabled user groups."
  ([connection usergroup]
   (list connection usergroup {}))
  ([connection usergroup optionals]
   (->>
    optionals
    stringify-keys
    (merge {"usergroup" usergroup})
    (slack-request connection "usergroups.users.list"))))

(defn update
  "Update the list of users for a user group
  Optional argument:
  - include_count: include the number of users in the user group"
  ([connection usergroup users]
   (update connection usergroup users {}))
  ([connection usergroup users optionals]
   (->>
    optionals
    stringify-keys
    (merge {"usergroup" usergroup,
            "users" (clojure.string/join \, users)})
    (slack-request connection "usergroups.users.update"))))
