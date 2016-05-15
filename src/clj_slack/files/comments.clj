(ns clj-slack.files.comments
  (:require [clj-slack.core :refer [slack-request stringify-keys]]))

(defn add
  "Add a comment to an existing file.
  Optional arguments are:
  - channel: channel id (encoded) of which location to associate with the new comment"
  ([connection file comment]
   (add connection file comment {}))
  ([connection file comment optionals]
   (->> optionals
        stringify-keys
        (merge {"file"    file
                "comment" comment})
        (slack-request connection "files.comments.add"))))

(defn delete
  "Delete an existing comment on a file.
  Only the original author of the comment or a Team Administrator may delete a file comment."
  [connection file id]
  (slack-request connection "files.comments.delete" {"file" file "id" id}))

(defn edit
  "Edit an existing comment on a file. Only the user who created a comment may make edits."
  [connection file id comment]
  (slack-request connection "files.comments.edit" {"file" file "id" id "comment" comment}))
