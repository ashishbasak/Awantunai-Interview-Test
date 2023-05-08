INSERT INTO tbl_users(username, id)
VALUES ('username', 1),
       ('to-user-name', 2)
;

INSERT INTO tbl_user_logins(token, user_id, id)
VALUES ('user-token', 1, 1);

INSERT INTO tbl_balances(amount, debit_amount, user_id, id)
VALUES (10000, 0, 1, 1),
       (10000, 0, 2, 2);
