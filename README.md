# 💬 SChat

This is the opensource massenger.

# ⚙️ Structure of project

## 🗃️ Data Bases

The project will use 4 databases:

1. Cassandra for storing messages.
2. Redis for caching
3. Just a file system for storing photos\videos
4. PostgreSQL for storing user data.

### Casandra

This database used for save messages and posts.

<details>
    <summary>How to install</summary>

```bash
CREATE TABLE posts(id int PRIMARY KEY, message text, pinned text, date date, time time, user_id int, hashtags_visible list<text>, hashtags_invisible list<text>, likes int);
CREATE TABLE answeres(id int PRIMARY KEY, message text, date date, time time, post_id int, answare_id int, gif_link text);
CREATE TABLE personal(id int PRIMARY KEY, message text, date date, time time, user_id int, chat_id int, links list<text>, answare_id int, forwarded_id int, gif_link text);
CREATE TABLE chats(id int PRIMARY KEY, name text, description text, date date, time time, users list<int>, secret text, messages list<int>, avatar text, is_secret bool);```
```

 **Posts:**

| Id      | Message | Pinned      | Date | Time | User ID | Hashtags (Visible) | Hashtags (Invisible) | Likes   |
| ------- | ------- | ----------- | ---- | ---- | ------- | ------------------ | -------------------- | ------- |
| Integer | Text    | Text (link) | Date | Time | Integer | [Text]             | [Text]               | Integer |

**Answeres:**

| Id      | Message | Date | Time | Post ID | Answare ID | GIF Link |
| ------- | ------- | ---- | ---- | ------- | ---------- | -------- |
| Integer | Text    | Date | Time | Integer | Integer    | Text     |

**Chats:**

| Id      | Name | Description | Date | Time | Users     | Secret | Messages  | Avatar        | Is Secret |
| ------- | ---- | ----------- | ---- | ---- | --------- | ------ | --------- | ------------- | --------- |
| Integer | Text | Text        | Date | Time | [Integer] | Text   | [Integer] | [Text (path)] | bool      |

**Personal:**

| Id      | Massege | Date | Time | User ID | Chat ID | Links         | Answare ID | Forwarded ID | GIF Link |
| ------- | ------- | ---- | ---- | ------- | ------- | ------------- | ---------- | ------------ | -------- |
| Integer | Text    | Date | Time | Integer | Integer | [Text (path)] | Integer    | Integer      | Text     |

</details>

### PostgreSQL

This database used for save user's accounts.

<details>
    <summary>How to install</summary>

```bash
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    password TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    username TEXT UNIQUE NOT NULL,
    question_type TEXT,
    question_answer TEXT,
    secret TEXT,
    date DATE,
    time TIME,
    groups INTEGER[],
    contacts INTEGER[],
    favorites TEXT[],
    avatar TEXT,
    name TEXT,
    subscriptions INTEGER[],
    likes INTEGER[],
    type TEXT,
    two_factor TEXT
);

```

**Users:**

| ID      | Password | Email | Username | Question (type) | Question (answer) | Secret | Date     | Time | Groups    | Contacts  | Favorits | Avatar | Name | Subscriptions | Likes     | Type | Two Factor |
| ------- | -------- | ----- | -------- | --------------- | ----------------- | ------ | -------- | ---- | --------- | --------- | -------- | ------ | ---- | ------------- | --------- | ---- | ---------- |
| Integer | Text     | Text  | Text     | Text            | Text              | Text   | Datetime | Time | [Integer] | [Integer] | [Text]   | Text   | Text | [Integer]     | [Integer] | Text | Text       |

</details>