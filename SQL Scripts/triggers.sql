CREATE TRIGGER reviews_after_insert
	AFTER INSERT ON reviews
		FOR EACH ROW
			UPDATE trips 
			SET rating_total = (SELECT AVG(rating) 
            FROM reviews where trips_trip_id = trip_id);

CREATE TRIGGER reviews_after_delete
	AFTER DELETE ON reviews
		FOR EACH ROW
			UPDATE trips 
			SET rating_total = (SELECT AVG(rating) 
            FROM reviews where trips_tri¢p_id = trip_id);