-- liquibase formatted sql

-- changeset dzimin:1

CREATE TABLE IF NOT EXISTS ads_comment
(
    pk         BIGSERIAL PRIMARY KEY,
    author     integer REFERENCES users (id),
    created_at text,
    text       text
)
