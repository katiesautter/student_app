#!/bin/bash
psql -U ksautter -d sea <<EOF
DROP TABLE users;
DROP TABLE posts;
DROP TABLE events;
DROP TABLE locations;
DROP TABLE private_events_users;
EOF
