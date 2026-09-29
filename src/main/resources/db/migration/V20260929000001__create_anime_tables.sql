CREATE TABLE genre (
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR(50) NOT NULL,
    mal_genre_id  INT NULL,
    CONSTRAINT uk_genre_name UNIQUE (name),
    CONSTRAINT uk_genre_mal_genre_id UNIQUE (mal_genre_id)
);

CREATE TABLE anime (
    id            BIGINT AUTO_INCREMENT PRIMARY KEY,
    mal_id        BIGINT NOT NULL,
    title         VARCHAR(255) NOT NULL,
    description   TEXT NULL,
    status        VARCHAR(20) NOT NULL,
    aired_from    DATE NULL,
    aired_to      DATE NULL,
    broadcast_day VARCHAR(20) NULL,
    season        VARCHAR(10) NULL,
    season_year   INT NULL,
    rating        DECIMAL(2,1) NULL,
    CONSTRAINT uk_anime_mal_id UNIQUE (mal_id)
);

CREATE TABLE anime_genre (
    anime_id BIGINT NOT NULL,
    genre_id BIGINT NOT NULL,
    PRIMARY KEY (anime_id, genre_id),
    CONSTRAINT fk_anime_genre_anime FOREIGN KEY (anime_id) REFERENCES anime (id) ON DELETE CASCADE,
    CONSTRAINT fk_anime_genre_genre FOREIGN KEY (genre_id) REFERENCES genre (id) ON DELETE CASCADE
);
