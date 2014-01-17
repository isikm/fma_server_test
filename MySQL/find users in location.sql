use testws;

SELECT a.FULL_NAME, a.AGE, b.LOCATION_NAME
FROM PERSON a, LOCATION b
WHERE a.USER_LOCATION = b.ID
AND b.ID = '3'
ORDER BY a.ID DESC
LIMIT 30 ;