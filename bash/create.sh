#!/bin/bash
psql -U ksautter -d sea <<EOF
CREATE TABLE locations (id int, name varchar(100));
CREATE TABLE posts (id int, message varchar(1000), fk_user_id int, fk_events_id int);
CREATE TABLE users (id int, username varchar(50), password varchar(50));
CREATE TABLE events (id int, title varchar(150), status varchar(15), date_time TIMESTAMP, fk_location_id int);
CREATE TABLE private_events_users (id int, fk_user_id int, fk_events_id int);
EOF
