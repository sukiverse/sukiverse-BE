ALTER TABLE anime
    ADD COLUMN title_kr VARCHAR(255) NULL AFTER title,
    ADD COLUMN title_jp VARCHAR(255) NULL AFTER title_kr,
    ADD COLUMN title_en VARCHAR(255) NULL AFTER title_jp;

UPDATE anime SET title_en = title;

ALTER TABLE anime DROP COLUMN title;
