INSERT INTO tbl_users(username, id)
VALUES ('username', 1),
       ('username-2', 2),
       ('username-3', 3),
       ('username-4', 4),
       ('username-5', 5)
;

INSERT INTO tbl_user_logins(token, user_id, id)
VALUES ('user-token', 1, 1);

INSERT INTO tbl_transactions(amount, recipient_id, sender_id, id)
VALUES (10000, 1, 5, 1)
     , (10001, 5, 1, 2)
     , (10003, 1, 5, 3)
     , (10002, 3, 1, 4)
     , (10005, 1, 5, 5)
     , (10004, 2, 1, 6)
     , (10007, 1, 5, 7)
     , (10006, 1, 5, 8)
     , (10009, 2, 1, 9)
     , (10008, 1, 5, 10)
     , (10011, 3, 5, 11)
     , (10012, 4, 5, 12)
     , (10013, 2, 5, 13);
