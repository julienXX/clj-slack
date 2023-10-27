(ns clj-slack.chat
  (:refer-clojure :exclude [update])
  (:require [clj-slack.core :refer [slack-request slack-post-request stringify-keys]]
            [clojure.data.json :refer [write-str]]))

(defn- serialize-option [option-key options]
  (let [option-value (option-key options)]
    (if (and option-value (not (string? option-value)))
      (assoc options option-key (write-str option-value))
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
  - attachments: structured message attachments. (NB: Slack recommends using Blocks
    instead of legacy attachments:
    https://api.slack.com/messaging/composing/layouts#secondary-attachments)
  - unfurl_links: pass true to enable unfurling of primarily text-based content
  - unfurl_media: pass false to disable unfurling of media content
  - icon_url: URL to an image to use as the icon for this message
  - icon_emoji: emoji to use as the icon for this message. Overrides icon_url"
  ([connection channel-id text]
   (post-message connection channel-id text {}))
  ([connection channel-id text optionals]
   (->> optionals
        (serialize-option :blocks)
        (serialize-option :attachments)
        stringify-keys
        (merge {"channel" channel-id
                "text" text})
        (slack-post-request connection "chat.postMessage"))))

(defn post-ephemeral
  "Sends an ephemeral message to a user in a channel.
  Optional arguments are:
  - username: name of bot
  - as_user: pass true (as a string) to post the message as the authed user, instead of as a bot
  - parse: change how messages are treated
  - link_names: find and link channel names and usernames
  - blocks: structured message blocks
  - attachments: structured message attachments. (NB: Slack recommends using Blocks
    instead of legacy attachments:
    https://api.slack.com/messaging/composing/layouts#secondary-attachments)
  - unfurl_links: pass true to enable unfurling of primarily text-based content
  - unfurl_media: pass false to disable unfurling of media content
  - icon_url: URL to an image to use as the icon for this message
  - icon_emoji: emoji to use as the icon for this message. Overrides icon_url
  - thread_ts: Provide another message's ts value to post this message in a thread. 
    Avoid using a reply's ts value; use its parent's value instead.
    Ephemeral messages in threads are only shown if there is already an active thread."
  ([connection channel-id text]
   (post-ephemeral connection channel-id text {}))
  ([connection channel-id text optionals]
   (->> optionals
        (serialize-option :blocks)
        (serialize-option :attachments)
        stringify-keys
        (merge {"channel" channel-id
                "text" text})
        (slack-post-request connection "chat.postEphemeral"))))

(defn update
  "Sends a message to a channel."
  [connection timestamp channel-id text]
  (slack-request connection "chat.update" {"ts" timestamp "channel" channel-id "text" text}))

(defn get-permalink
  "Retrieve a permalink URL for a specific extant message"
  [connection channel-id message-ts]
  (slack-request connection "chat.getPermalink" {"channel" channel-id "message_ts" message-ts}))
