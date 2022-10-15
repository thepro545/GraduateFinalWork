-- liquibase formatted sql

-- changeset maxon4ik:1

CREATE TABLE IF NOT EXISTS images
(
    id         BIGSERIAL PRIMARY KEY,
    file_path      varchar NOT NULL,
    image   varchar NOT NULL,
    file_size integer NOT NULL,
    ads_id integer REFERENCES ads (id)
);
