CREATE DEFINER=`root`@`localhost` PROCEDURE `get_rating_level_by_input`(
	IN rating_level_param INT
)
BEGIN
	SELECT *
	FROM reviews
    WHERE rating = rating_level_param;
END