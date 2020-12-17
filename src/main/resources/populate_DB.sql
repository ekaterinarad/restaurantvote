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
VALUES ('user', '{noop}test1', 1),
       ('admin', '{noop}test2', 1);

INSERT INTO menus (id, name)
VALUES (100000, 'Vegetarian'),
       (100001, 'Luxury'),
       (100002, 'Vegan');

INSERT INTO restaurants (id, name, menu_id)
VALUES (100000, 'Pushkin', 100000),
       (100001, 'McDonalds', 100001);

INSERT INTO votes (id, date, rest_id, username)
VALUES (100000, '2020-01-30 10:00:00', 100000, 'user'),
       (100001, '2020-01-31 10:00:00', 100001, 'user');

INSERT INTO dishes (id, name, price, menu_id)
VALUES (100000, 'Burger', 100,  100001),
       (100001, 'Salad', 200, 100000),
       (100002, 'Apple', 300, 100002);
