CREATE TABLE users (
    id int,
    username varchar(50),
    password varchar(50)
);

CREATE TABLE posts (
    id int,
    status varchar(15),  -- public or private
    message varchar(1000),
    fk_user_id int,
    fk_events_id int
);

CREATE TABLE events (
    id int,
    title varchar(150),  
    date_time TIMESTAMP,
    fk_location_id int

);

CREATE TABLE location (
    id int,
    name varchar(100) 
);

CREATE TABLE private_user (
    id int,
    fk_user_id int,
    fk_events_id int

);
