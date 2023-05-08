CREATE TABLE IF NOT EXISTS tbl_users
(
    username    VARCHAR(255),
    id          INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tbl_students
(
    username    VARCHAR(255),
    password    VARCHAR(255),
    email        VARCHAR(50),
    address     VARCHAR(255),
    gender      VARCHAR(8),
    token       VARCHAR(255),
    id          INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id)
);

