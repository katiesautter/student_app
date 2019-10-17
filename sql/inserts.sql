INSERT INTO users (username, password) VALUES ('beccathorne', 'buckyb');

INSERT INTO users (username, password) VALUES ('codycook', 'bigbear27');

INSERT INTO users (username, password) VALUES ('katies130', 'Rose200');

INSERT INTO users (username, password) VALUES ('jamata', 'lilHoze');

INSERT INTO users (username, password) VALUES ('babydragon', 'dragons!');

INSERT INTO locations (name) VALUES ('Shrader');

INSERT INTO locations (name) VALUES ('Wolly Lawn');

INSERT INTO locations (name) VALUES ('Student Center');

INSERT INTO locations (name) VALUES ('Hebrews');

INSERT INTO locations (name) VALUES ('Gymnasium');

INSERT INTO locations (name) VALUES ('Spange Parlor');

INSERT INTO events (title, status, date_time, fk_location_id) VALUES ('Game Night', 'public', current_timestamp, (SELECT id FROM locations WHERE name = 'Shrader'));    

INSERT INTO events (title, status, date_time, fk_location_id) VALUES ('Welcome Back Bash', 'public', current_timestamp, (SELECT id FROM locations WHERE name = 'Wolly Lawn')); 

INSERT INTO events (title, status, date_time, fk_location_id) VALUES ('Basement Shrader Club', 'private', current_timestamp, (SELECT id FROM locations WHERE name = 'Shrader')); 

INSERT INTO events (title, status, date_time, fk_location_id) VALUES ('Volleyball Game', 'public', current_timestamp, (SELECT id FROM locations WHERE name = 'Gymnasium')); 

INSERT INTO events (title, status, date_time, fk_location_id) VALUES ('Comp Sci Study Group', 'private', current_timestamp, (SELECT id FROM locations WHERE name = 'Hebrews'));

INSERT INTO events (title, status, date_time, fk_location_id) VALUES ('Dance Practice', 'private', current_timestamp, (SELECT id FROM locations WHERE name = 'Gymnasium'));

INSERT INTO events (title, status, date_time, fk_location_id) VALUES ('Karaoke Night', 'public', current_timestamp, (SELECT id FROM locations WHERE name = 'Spange Parlor'));

INSERT INTO events (title, status, date_time, fk_location_id) VALUES ('International CLub Meeting', 'public', current_timestamp, (SELECT id FROM locations WHERE name = 'Spange Parlor'));

INSERT INTO posts (message, fk_user_id, fk_events_id) VALUES ('Come study for comp sci exam 3', (SELECT id FROM users WHERE username = 'codycook'), (SELECT id FROM events WHERE title = 'Comp Sci Study Group'));


INSERT INTO posts (message, fk_user_id, fk_events_id) VALUES ('Come sing your heart out at Karoke night this Friday at 8!', (SELECT id FROM users WHERE username = 'beccathorne'), (SELECT id FROM events WHERE title = 'Karaoke Night'));


INSERT INTO posts (message, fk_user_id, fk_events_id) VALUES ('Come support the girls volleyball team!!', (SELECT id FROM users WHERE username = 'codycook'), (SELECT id FROM events WHERE title = 'Volleyball Game'));

INSERT INTO posts (message, fk_user_id, fk_events_id) VALUES ('Volleyball game tonight!!', (SELECT id FROM users WHERE username = 'codycook'), (SELECT id FROM events WHERE title = 'Volleyball Game'));

INSERT INTO private_events_users (fk_user_id, fk_events_id) VALUES ((SELECT id FROM users WHERE username = 'codycook'), (SELECT id FROM events WHERE title = 'Comp Sci Study Group'));

INSERT INTO private_events_users (fk_user_id, fk_events_id) VALUES ((SELECT id FROM users WHERE username = 'katies130'), (SELECT id FROM events WHERE title = 'Basement Shrader Club'));





