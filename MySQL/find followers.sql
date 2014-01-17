use testws;

SELECT a.FULL_NAME, a.AGE
FROM PERSON a, FOLLOWERS b
WHERE a.ID = b.followerID
AND b.followedID = '1'
ORDER BY b.follow_id DESC
LIMIT 30 ;