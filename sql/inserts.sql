INSERT INTO users
VALUES ('1', 'katiesautter', 'Horses12'); 

INSERT INTO users
VALUES ('2', 'babydragon', 'dragons10'); 

INSERT INTO users
VALUES ('3', 'beccathorne', 'buckyb'); 

INSERT INTO posts
VALUES ('1', 'public', 'Come to our Shrader Game Night', '2', '1'); 

INSERT INTO posts
VALUES ('2', 'public', 'Capture the Flag', '1', '2'); 

INSERT INTO events
VALUES ('1', 'Game Night', current_timestamp, '1'); 

INSERT INTO events
VALUES ('2', 'Capture the Flag', current_timestamp, '2'); 

INSERT INTO locations 
VALUES ('1', 'Shrader');

INSERT INTO locations 
VALUES ('2', 'Wolly lawn');

INSERT INTO private_events_users 
VALUES ('1', '2', '1');

