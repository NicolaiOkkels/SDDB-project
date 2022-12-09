CREATE DEFINER=`root`@`localhost` PROCEDURE `get_ratings_by_user`(
	IN userID INT
)
BEGIN
	SELECT * 
	FROM reviews
	WHERE userId = user_user_id;
END