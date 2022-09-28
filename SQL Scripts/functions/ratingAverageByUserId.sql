CREATE DEFINER=`root`@`localhost` FUNCTION `RatingAverage`(tripId INT) RETURNS decimal(9,2)
    DETERMINISTIC
BEGIN
    DECLARE ratingAverage INT;
    SET ratingAverage = (SELECT AVG(`rating`) FROM reviews WHERE tripId = trips_trip_id);
    RETURN ratingAverage;
END