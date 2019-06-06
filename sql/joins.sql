select * 
FROM users JOIN 
     private_events_users ON users.id=private_events_users.fk_user_id JOIN 
     events ON events.id= private_events_users.fk_events_id
WHERE status = 'private';    --from previous lesson

Select * 
from posts JOIN 
     events ON events.id=posts.fk_events_id
WHERE posts.fk_user_id = '2';  --selects events babydragon has posted in

Select * 
from events JOIN 
     posts ON events.id=posts.fk_events_id JOIN users ON posts.fk_user_id=users.id
WHERE users.username = 'babydragon';   --selects events babydragon has posted

SELECT *
from events 
WHERE title = 'Capture the Flag'
ORDER BY date_time ASC;    -- list posts about capture the flag in the order they were created

SELECT *
from posts JOIN 
     events ON posts.fk_events_id=events.id
WHERE title = 'Capture the Flag'
ORDER BY date_time ASC;    -- list posts about capture the flag in the order they were created


Select * 
from events JOIN 
     posts ON events.id=posts.fk_events_id JOIN users ON posts.fk_user_id=users.id
WHERE username = 'katiesautter' OR status = 'public'; --lists posts 'katiesautter' can see and post in 


SELECT * 
FROM events JOIN
     locations ON events.fk_location_id=locations.id
WHERE name = 'Wolly lawn';                   --events being held on the wolly 


 
