(ns clj-slack.chat
  (:refer-clojure :exclude [update])
  (:require [clj-slack.core :refer [slack-request slack-post-request stringify-keys]]
            [clojure.data.json :refer [write-str]]))

(defn- serialize-blocks [options]
  (let [blocks (:blocks options)]
    (if (and blocks (not (string? blocks)))
      (assoc options :blocks (write-str blocks))
      options)))

(defn delete
  "Deletes a message."
  [connection timestamp channel-id]
  (slack-request connection "chat.delete" {"ts" timestamp "channel" channel-id}))

(defn post-message
  "Sends a message to a channel.
  Optional arguments are:
  - username: name of bot
  - as_user: pass true (as a string) to post the message as the authed user, instead of as a bot
  - parse: change how messages are treated
  - link_names: find and link channel names and usernames
  - blocks: structured message blocks
  - unfurl_links: pass true to enable unfurling of primarily text-based content
  - unfurl_media: pass false to disable unfurling of media content
  - icon_url: URL to an image to use as the icon for this message
  - icon_emoji: emoji to use as the icon for this message. Overrides icon_url"
  ([connection channel-id text]
   (post-message connection channel-id text {}))
  ([connection channel-id text optionals]
   (->> optionals
        serialize-blocks
        stringify-keys
        (merge {"channel" channel-id
                "text" text})
        (slack-post-request connection "chat.postMessage"))))

(defn update
  "Sends a message to a channel."
  [connection timestamp channel-id text]
  (slack-request connection "chat.update" {"ts" timestamp "channel" channel-id "text" text}))
