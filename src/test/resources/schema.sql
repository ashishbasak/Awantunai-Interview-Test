CREATE TABLE IF NOT EXISTS tbl_users
(
    username    VARCHAR(255),
    id          INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tbl_user_logins
(
    user_id     NUMERIC,
    token       VARCHAR(255),
    id          INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tbl_balances
(
    user_id     NUMERIC,
    amount      NUMERIC,
    debit_amount NUMERIC,
    id          INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tbl_transactions
(
    amount      NUMERIC,
    recipient_id NUMERIC,
    sender_id   NUMERIC,
    id          INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id)
);
