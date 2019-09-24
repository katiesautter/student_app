CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username varchar(50) NOT NULL UNIQUE, 
    password varchar(50)
);  

CREATE TABLE locations (
    id SERIAL PRIMARY KEY,
    name varchar(100) NOT NULL UNIQUE
);

CREATE TABLE events (
    id SERIAL PRIMARY KEY,
    title varchar(150) NOT NULL, 
    status varchar(15), 
    date_time TIMESTAMP NOT NULL, 
    fk_location_id int REFERENCES locations(id) NOT NULL
);

CREATE TABLE posts (
    id SERIAL PRIMARY KEY, 
    message varchar(1000) NOT NULL, 
    fk_user_id int REFERENCES users(id) NOT NULL,
    fk_events_id int REFERENCES events(id) NOT NULL
);
--so you know the users in a private event
CREATE TABLE private_events_users (
    id SERIAL PRIMARY KEY,  
    fk_user_id int REFERENCES users(id) NOT NULL,
    fk_events_id int REFERENCES events(id) NOT NULL
);


--Multiline format is better because it makes the command more concise and easier 
--to read/understand what the command is doing. also makes it easier to fix and
--spot errors
