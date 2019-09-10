DROP SCHEMA IF EXISTS courier CASCADE;

CREATE SCHEMA courier;

CREATE TABLE courier.task
(
    task_id   serial PRIMARY KEY,
    order_id  bigint UNIQUE                  NOT NULL,
    task_date timestamp(6) WITHOUT TIME ZONE NOT NULL DEFAULT current_timestamp
);

CREATE TABLE courier.role
(
    role_id   serial PRIMARY KEY,
    role_name varchar(100)
);

CREATE TABLE courier.users
(
    user_id       serial PRIMARY KEY,
    user_login    varchar(100) UNIQUE,
    user_password varchar(100),
    role_id       integer REFERENCES courier.role NOT NULL
);

INSERT INTO courier.role (role_name)
VALUES ('Courier');
INSERT INTO courier.role (role_name)
VALUES ('Operator');


