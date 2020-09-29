/*
Enter your query below.
Please append a semicolon ";" at the end of the query
*/
SELECT DISTINCT USERS.name, SUM(RIDES.distance) as distance_traveled
FROM USERS JOIN RIDES
ON USERS.id = RIDES.user_id
GROUP BY USERS.id, USERS.name /* Just in case there's multiple people with the same name*/
ORDER BY distance_traveled DESC, name ASC LIMIT 100;