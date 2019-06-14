CREATE TABLE users (
    id int, 
    username varchar(50), 
    password varchar(50)
);  

CREATE TABLE posts (
    id int, 
    message varchar(1000), 
    fk_user_id int, 
    fk_events_id int
);

CREATE TABLE events (
    id int, 
    title varchar(150), 
    status varchar(15), 
    date_time TIMESTAMP, 
    fk_location_id int
);

CREATE TABLE locations (
    id int, 
    name varchar(100)
);

CREATE TABLE private_events_users (
    id int,    
    fk_user_id int, 
    fk_events_id int
);

--Multiline format is better because it makes the command more concise and easier 
--to read/understand what the command is doing. also makes it easier to fix and
--spot errors
