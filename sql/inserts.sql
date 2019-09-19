INSERT INTO users (username, password) VALUES ('beccathorne', 'buckyb');

INSERT INTO users (username, password) VALUES ('codycook', 'bigbear27');

INSERT INTO locations (name) VALUES ('Shrader');

INSERT INTO events (title, status, date_time, fk_location_id) VALUES ('Game Night', 'public', current_timestamp, (SELECT id FROM locations WHERE name = 'Shrader'));    
