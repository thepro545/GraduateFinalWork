-- liquibase formatted sql

-- changeset maxon4ik:1

CREATE TABLE IF NOT EXISTS images
(
    id         BIGSERIAL PRIMARY KEY,
    file_path  varchar NOT NULL,
    image      bytea   NOT NULL,
    file_size  integer NOT NULL,
    ads_id     integer REFERENCES ads (id),
    media_type text
);
-- changeset dzimin:2
ALTER TABLE ads
    ADD COLUMN image_id integer REFERENCES images (id);

-- changeset dzimin:2
ALTER TABLE ads
    ADD COLUMN image_id integer REFERENCES images (id);