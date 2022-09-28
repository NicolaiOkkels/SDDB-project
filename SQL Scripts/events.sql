CREATE EVENT package_summer_discount
	ON SCHEDULE AT '2023-06-22 23:59:59'
    DO UPDATE packages.discount
	SET packages.discount = package.discount * 1.4;