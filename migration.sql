DROP DATABASE AdListerDB21;

CREATE DATABASE AdListerDB21;

USE AdListerDB21;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS media;
DROP TABLE IF EXISTS pivot_media;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS pivot_categories;
DROP TABLE IF EXISTS categories;

CREATE TABLE users
(
    id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL,
    email    VARCHAR(240) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ads
(
    id          INT UNSIGNED  NOT NULL AUTO_INCREMENT,
    user_id     INT UNSIGNED  NOT NULL,
    title       VARCHAR(240)  NOT NULL,
    description TEXT          NOT NULL,
    price       decimal(6, 2) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
        ON DELETE CASCADE
);

CREATE TABLE categories
(
    id            INT UNSIGNED NOT NULL AUTO_INCREMENT,
    category_name VARCHAR(250) not null,
    PRIMARY KEY (id)
);

CREATE table pivot_categories
(
    ads_id        int unsigned not null,
    categories_id int unsigned not null,
    foreign key (categories_id) references categories (id),
    foreign key (ads_id) references ads (id) on delete cascade
);

CREATE TABLE media
(
    id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
    location varchar(250),
    PRIMARY KEY (id)
);

CREATE TABLE pivot_media
(
    media_id int unsigned not null,
    ad_id    int unsigned not null,
    foreign key (media_id) references media (id) on delete cascade,
    foreign key (ad_id) references ads (id) on delete cascade
);


