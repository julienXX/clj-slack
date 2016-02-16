(ns clj-slack.usergroups
  (:require [clj-slack.core :refer [slack-request stringify-keys]])
  (:refer-clojure :exclude [list update]))

(defn create
  "Create a user group
  Optional arguments are:
  - handle: A mention handle. Must be unique among channels, users and user groups.
  - description: A short description of the user group.
  - channels: A comma separated string of encoded channel IDs for which the user group uses as a default.
  - include_count: Include the number of users in each user group."
  ([connection name]
   (create connection name {}))
  ([connection name optionals]
   (->>
    optionals
    stringify-keys
    (merge {"name" name})
    (slack-request connection "usergroups.create"))))

(defn disable
  "Disable an existing user group
  Optional argument:
  - include_count: include the number of users in the user group"
  ([connection usergroup]
   (disable connection usergroup {}))
  ([connection usergroup optionals]
   (->>
    optionals
    stringify-keys
    (merge {"usergroup" usergroup})
    (slack-request connection "usergroups.disable"))))

(defn enable
  "Enable a user group
  Optional argument:
  - include_count: include the number of users in the user group"
  ([connection usergroup]
   (enable connection usergroup {}))
  ([connection usergroup optionals]
   (->>
    optionals
    stringify-keys
    (merge {"usergroup" usergroup})
    (slack-request connection "usergroups.enable"))))

(defn list
  "List all user groups for a team
  Optional arguments are:
  - include_disabled: Include disabled user groups.
  - include_count: Include the number of users in each user group.
  - include_users: Include the list of users for each user group."
  ([connection]
   (list connection {}))
  ([connection optionals]
   (->>
    optionals
    stringify-keys
    (slack-request connection "usergroups.list"))))

(defn update
  "Update an existing user group
  Optional arguments are:
  - name: A name for the user group. Must be unique among user groups.
  - handle: A mention handle. Must be unique among channels, users and user groups.
  - description: A short description of the user group.
  - channels: A comma separated string of encoded channel IDs for which the user group uses as a default.
  - include_count: Include the number of users in the user group."
  ([connection usergroup]
   (update connection usergroup {}))
  ([connection usergroup optionals]
   (->>
    optionals
    stringify-keys
    (merge {"usergroup" usergroup})
    (slack-request connection "usergroups.update"))))
