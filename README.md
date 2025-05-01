# 💬 SChat

This is the opensource massenger.

# ⚙️ Structure of project

## 🗃️ Data Bases

### Casandra

This databes used for save messages and posts.

<details>
    <summary>How to install</summary>

```bash
CREATE TABLE post(id int PRIMARY KEY, message text, pinned text, date date, time time, user_id int, hashtags_visible text, hashtags_invisible text, likes int);
CREATE TABLE answares(id int PRIMARY KEY, message text, date date, time time, post_id int, answare_id int, gif_link text);
CREATE TABLE personal(id int PRIMARY KEY, message text, date date, time time, user_id int, chat_id int, links list<text>, answare_id int, forwarded_id int, gif_link text);
```

 **Post:**

| Id      | Message | Pinned      | Date | Time | User ID | Hashtags (Visible) | Hashtags (Invisible) | Likes   |
| ------- | ------- | ----------- | ---- | ---- | ------- | ------------------ | -------------------- | ------- |
| Integer | Text    | Text (link) | Date | Time | Integer | [Text]             | [Text]               | Integer |

**Answares:**

| Id      | Message | Date | Time | Post ID | Answare ID | GIF Link |
| ------- | ------- | ---- | ---- | ------- | ---------- | -------- |
| Integer | Text    | Date | Time | Integer | Integer    | Text     |

**Personal:**

| Id      | Massege | Date | Time | User ID | Chat ID | Links         | Answare ID | Forwarded ID | GIF Link |
| ------- | ------- | ---- | ---- | ------- | ------- | ------------- | ---------- | ------------ | -------- |
| Integer | Text    | Date | Time | Integer | Integer | [Text (path)] | Integer    | Integer      | Text     |

</details>