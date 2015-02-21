(ns clj-slack.files
  (:use [clj-slack.core :only [slack-request slack-post-request stringify-keys]])
  (:refer-clojure :exclude [list]))

(defn delete
  "Deletes a file from your team."
  [connection file-id]
  (slack-request connection "files.delete" {"file" file-id}))

(defn info
  "Gets information about a team file.
  Optional arguments are:
  - count: number of items to return per page
  - page: page number of results to return"
  ([connection file-id]
   (info connection file-id {}))
  ([connection file-id optionals]
   (->> optionals
        stringify-keys
        (merge {"file" file-id})
        (slack-request connection "files.info"))))

(defn list
  "Lists & filters team files.
  Optional arguments are:
  - user: filter files created by a single user
  - ts_from: filter files created after this timestamp
  - ts_to: filter files created before this timestamp
  - types: filter files by type
  - count: number of items to return per page
  - page: page number of results to return"
  ([connection]
   (list connection {}))
  ([connection optionals]
   (->> optionals
        stringify-keys
        (slack-request connection "files.list"))))

;; TODO should channels option receive a sequence?
(defn upload
  "Creates or uploads an existing file. Content can be a String, File or InputStream
  Optional arguments are:
  - filetype: internal file type identifier
  - filename: filename of file
  - title: title of file
  - initial_comment: initial comment to add to file
  - channels: list of channels to share the file into"
  ([connection content]
     (upload connection content {}))
  ([connection content optionals]
     (let [params (->> optionals
                       stringify-keys)]
       (if (string? content)
         ;; if content is string use get request (e.g. post a snippet)
         (slack-request connection "files.upload" (merge params {"content" content}))
         ;; otherwise assume it is a file or an inputstream and use post
         (slack-post-request connection "files.upload" (merge params {"file" content}))))))
