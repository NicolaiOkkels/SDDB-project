CREATE EVENT trip_summer_discount
	ON SCHEDULE AT '2023-06-22 23:59:59'
    DO UPDATE trips.price
	SET trips.price = trips.price * 0.75;

