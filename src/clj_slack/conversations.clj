(ns clj-slack.conversations
  (:refer-clojure :exclude [update])
  (:require [clj-slack.core :refer [slack-request slack-post-request stringify-keys]]
            [clojure.data.json :refer [write-str]]))

(defn archive
  "Archives a conversation."
  [connection channel-id]
  (slack-post-request connection "conversations.archive" {"channel" channel-id}))

(defn close
  "Closes a direct message or multi-person direct message."
  [connection channel-id]
  (slack-post-request connection "conversations.close" {"channel" channel-id}))

(defn create
  "Initiates a public or private channel-based conversation.
  Optional arguments are:
  - is_private: create a private channel
  - user_ids: a list of users (1 to 30) that will be added to the conversation"
  ([connection name optionals]
   (->> optionals
        stringify-keys
        (merge {"name" name})
        (slack-post-request connection "conversations.create"))))

(defn history
  "Fetches a conversation's history of messages and events.
  Optional arguments are:
  - cursor: Paginate through collections of data by setting the cursor parameter to a next_cursor attribute.
  - inclusive: Include messages with latest or oldest timestamp in results only when either timestamp is specified.
  - latest: End of time range of messages to include in results.
  - limit: The maximum number of items to return.
  - oldest: Start of time range of messages to include in results.
  "
  ([connection channel-id optionals]
   (->> optionals
        stringify-keys
        (merge {"channel" channel-id})
        (slack-request connection "conversations.history"))))

(defn info
  "Retrieve information about a conversation.
  Optional arguments are:
  - include_locale: Set this to true to receive the locale for this conversation.
  "
  ([connection channel-id optionals]
   (->> optionals
        stringify-keys
        (merge {"channel" channel-id})
        (slack-request connection "conversations.info"))))

(defn invite
  "Invites users to a channel."
  [connection channel-id user-ids]
  (slack-post-request connection "conversations.invite" {"channel" channel-id "users" user-ids}))

(defn join
  "Joins an existing conversation."
  [connection channel-id]
  (slack-post-request connection "conversations.join" {"channel" channel-id}))

(defn kick
  "Removes a user from a conversation."
  [connection channel-id user-id]
  (slack-post-request connection "conversations.kick" {"channel" channel-id "user" user-id}))

(defn leave
  "Leaves a conversation."
  [connection channel-id]
  (slack-post-request connection "conversations.leave" {"channel" channel-id}))

(defn list
  "Lists all channels in a Slack team.
  Optional arguments are:
  - cursor: Paginate through collections of data by setting the cursor parameter to a next_cursor attribute.
  - exclude_archived: Set to true to exclude archived channels from the list.
  - limit: The maximum number of items to return.
  - types: Mix and match channel types by providing a comma-separated list of any combination of public_channel, private_channel, mpim, im
  "
  ([connection optionals]
   (->> optionals
        stringify-keys
        (slack-request connection "conversations.list"))))

(defn members
  "Retrieve members of a conversation.
  Optional arguments are:
  - cursor: Paginate through collections of data by setting the cursor parameter to a next_cursor attribute.
  - limit: The maximum number of items to return.
  "
  ([connection channel-id optionals]
   (->> optionals
        stringify-keys
        (merge {"channel" channel-id})
        (slack-request connection "conversations.members"))))

(defn open
  "Opens or resumes a direct message or multi-person direct message.
  Optional arguments are:
  - channel: Resume a conversation by supplying an im or mpim's ID. Or provide the users field instead.
  - return_im: Boolean, indicates you want the full IM channel definition in the response.
  - users: Comma separated lists of users.
  "
  ([connection optionals]
   (->> optionals
        stringify-keys
        (slack-post-request connection "conversations.open"))))

(defn rename
  "Renames a conversation."
  [connection channel-id name]
  (slack-post-request connection "conversations.rename" {"channel" channel-id "name" name}))

(defn replies
  "Lists all channels in a Slack team.
  Optional arguments are:
  - cursor: Paginate through collections of data by setting the cursor parameter to a next_cursor attribute.
  - inclusive: Include messages with latest or oldest timestamp in results only when either timestamp is specified.
  - latest: End of time range of messages to include in results.
  - limit: The maximum number of items to return.
  - oldest: Start of time range of messages to include in results.
  "
  ([connection channel-id timestamp optionals]
   (->> optionals
        stringify-keys
        (merge {"channel" channel-id "ts" timestamp})
        (slack-request connection "conversations.replies"))))

(defn set-purpose
  "Sets the purpose for a conversation."
  [connection channel-id purpose]
  (slack-post-request connection "conversations.setPurpose" {"channel" channel-id "purpose" purpose}))

(defn set-topic
  "Sets the topic for a conversation."
  [connection channel-id topic]
  (slack-post-request connection "conversations.setTopic" {"channel" channel-id "topic" topic}))

(defn unarchive
  "Unarchives a conversation."
  [connection channel-id]
  (slack-post-request connection "conversations.unarchive" {"channel" channel-id}))
