CREATE DEFINER=`root`@`localhost` PROCEDURE `get_title_and_rating`()
BEGIN
	SELECT 
		title,
        rating
	FROM 
		reviews
	ORDER BY
		rating DESC;
    
END