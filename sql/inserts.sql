INSERT INTO users (username, password) VALUES ('beccathorne', 'buckyb');

INSERT INTO users (username, password) VALUES ('codycook', 'bigbear27');

INSERT INTO users (username, password) VALUES ('katiesautter', 'password');

INSERT INTO users (username, password) VALUES ('jamata', 'lilHoze');

INSERT INTO users (username, password) VALUES ('babydragon', 'dragons!');

INSERT INTO locations (name) VALUES ('Shrader Hall');

INSERT INTO locations (name) VALUES ('Wolly Lawn');

INSERT INTO locations (name) VALUES ('Mann Student Center');

INSERT INTO locations (name) VALUES ('Hebrews');

INSERT INTO locations (name) VALUES ('Lahue Gymnasium');

INSERT INTO locations (name) VALUES ('Spange Parlor');

INSERT INTO locations (name) VALUES ('Nease Library');

INSERT INTO locations (name) VALUES ('Gardner Hall');

INSERT INTO locations (name) VALUES ('Admissions');

INSERT INTO locations (name) VALUES ('Brickley Center');

INSERT INTO locations (name) VALUES ('Wollaston Church of the Nazarene');

INSERT INTO locations (name) VALUES ('Angell Hall');

INSERT INTO locations (name) VALUES ('Munro Hall');

INSERT INTO locations (name) VALUES ('Young Apartments');

INSERT INTO locations (name) VALUES ('Canterbury Hall');

INSERT INTO locations (name) VALUES ('Memorial Hall');

INSERT INTO locations (name) VALUES ('Shields Hall');

INSERT INTO locations (name) VALUES ('Cove Fine Arts Center');

INSERT INTO locations (name) VALUES ('No Location');

INSERT INTO locations (name) VALUES ('Off Campus');

INSERT INTO events (title, status, date_time, fk_location_id) VALUES ('Game Night', 'public', '2019-09-06', (SELECT id FROM locations WHERE name = 'Shrader Hall'));    

INSERT INTO events (title, status, date_time, fk_location_id) VALUES ('Volleyball Game', 'public', '2019-11-15', (SELECT id FROM locations WHERE name = 'Lahue Gymnasium')); 

INSERT INTO events (title, status, date_time, fk_location_id) VALUES ('Basement Shrader Club', 'private', '2019-12-07', (SELECT id FROM locations WHERE name = 'Shrader Hall')); 

INSERT INTO events (title, status, date_time, fk_location_id) VALUES ('Comp Sci Study Group', 'private', '2019-11-06', (SELECT id FROM locations WHERE name = 'Hebrews'));

INSERT INTO events (title, status, date_time, fk_location_id) VALUES ('Dance Practice', 'private', '2020-01-06', (SELECT id FROM locations WHERE name = 'Lahue Gymnasium'));

INSERT INTO events (title, status, date_time, fk_location_id) VALUES ('Karaoke Night', 'public', '2019-01-16', (SELECT id FROM locations WHERE name = 'Spange Parlor'));

INSERT INTO events (title, status, date_time, fk_location_id) VALUES ('International Club Meeting', 'public', '2019-01-31', (SELECT id FROM locations WHERE name = 'Mann Student Center'));

INSERT INTO posts (message, date_time, fk_user_id, fk_events_id) VALUES ('Come study for comp sci exam 3', current_timestamp, (SELECT id FROM users WHERE username = 'jamata'), (SELECT id FROM events WHERE title = 'Comp Sci Study Group'));


INSERT INTO posts (message, date_time, fk_user_id, fk_events_id) VALUES ('Come sing your heart out at Karoke night this Friday at 8!', current_timestamp, (SELECT id FROM users WHERE username = 'beccathorne'), (SELECT id FROM events WHERE title = 'Karaoke Night'));


INSERT INTO posts (message, date_time, fk_user_id, fk_events_id) VALUES ('Come support the girls volleyball team!!', current_timestamp, (SELECT id FROM users WHERE username = 'codycook'), (SELECT id FROM events WHERE title = 'Volleyball Game'));

INSERT INTO posts (message, date_time, fk_user_id, fk_events_id) VALUES ('Volleyball game tonight!!', current_timestamp, (SELECT id FROM users WHERE username = 'beccathorne'), (SELECT id FROM events WHERE title = 'Volleyball Game'));

INSERT INTO private_events_users (fk_user_id, fk_events_id) VALUES ((SELECT id FROM users WHERE username = 'codycook'), (SELECT id FROM events WHERE title = 'Comp Sci Study Group'));

INSERT INTO private_events_users (fk_user_id, fk_events_id) VALUES ((SELECT id FROM users WHERE username = 'katiesautter'), (SELECT id FROM events WHERE title = 'Basement Shrader Club'));





