DELETE FROM users;
DELETE FROM AUTHORITIES;
DELETE FROM votes;
DELETE FROM restaurants;
DELETE FROM menus;
DELETE FROM dishes;
ALTER SEQUENCE GLOBAL_SEQ RESTART WITH 100005;

INSERT INTO authorities (username, authority)
VALUES ('user', 'ROLE_USER'),
       ('admin', 'ROLE_ADMIN');

INSERT INTO users (username, password, enabled)
VALUES ('user', '{bcrypt}$2a$10$QlznDgdy3WT5296BcmRdf.gDzDROoONYhtF8Rnn7lvgUI2Tu/Yy8i', 1),
       ('admin', '{bcrypt}$2a$10$cpW7ngMF433nSTS9anHUH.b/bAilv6DdwUUMbSAuzHtwYorTD5HjK', 1);

INSERT INTO menus (id, name, date)
VALUES (100000, 'Vegetarian', '2020-12-31'),
       (100001, 'Luxury', '2020-12-30'),
       (100002, 'Vegan', '2020-12-30');

INSERT INTO dishes (id, name, price)
VALUES (100000, 'Burger', 100),
       (100001, 'Salad', 200),
       (100002, 'Apple', 300);

INSERT INTO restaurants (id, name, menu_id)
VALUES (100000, 'Pushkin', 100000),
       (100001, 'McDonalds', 100001);

INSERT INTO votes (id, date, time, rest_id, username)
VALUES (100000, '2020-01-30', '10:00:00', 100000, 'user'),
       (100001, '2020-01-31', '10:00:00', 100001, 'user');

INSERT INTO menu_dish (menu_id, dish_id)
VALUES (100000, 100000),
       (100000, 100001),
       (100000, 100002),
       (100001, 100000),
       (100001, 100002),
       (100002, 100000);


