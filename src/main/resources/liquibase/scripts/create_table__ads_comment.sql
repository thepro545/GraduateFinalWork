-- liquibase formatted sql

-- changeset dzimin:2

CREATE TABLE IF NOT EXISTS ads_comment
(
    pk         BIGSERIAL PRIMARY KEY,
    author_id  integer REFERENCES users (id),
    created_at timestamp,
    text       text,
    ads_id     integer REFERENCES ads (pk)
);
