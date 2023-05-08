INSERT INTO tbl_users(username, id)
VALUES ('username', 1);

INSERT INTO tbl_user_logins(token, user_id, id)
VALUES ('user-token', 1, 1);

INSERT INTO tbl_balances(amount, user_id, id)
VALUES (10000, 1, 1)
