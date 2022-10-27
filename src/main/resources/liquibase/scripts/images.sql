-- liquibase formatted sql

-- changeset maxon4ik:1

CREATE TABLE IF NOT EXISTS image
(
    id         BIGSERIAL PRIMARY KEY,
    image      bytea   NOT NULL,
    file_size  integer NOT NULL,
    media_type text
);

-- changeset dzimin:2
ALTER TABLE ads
    ADD COLUMN image_id integer REFERENCES image (id);