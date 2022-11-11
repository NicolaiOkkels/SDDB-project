CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `mydb`.`trip_view` AS
    SELECT 
        `mydb`.`trips`.`title` AS `title`,
        `mydb`.`trips`.`price` AS `price`,
        `mydb`.`trips`.`description` AS `description`,
        `mydb`.`trips`.`length` AS `length`,
        `mydb`.`trips`.`availabilty` AS `availabilty`,
        `mydb`.`packages`.`description` AS `package_name`,
        `mydb`.`locations`.`name` AS `location_name`,
        `mydb`.`countries`.`name` AS `country_name`
    FROM
        (((`mydb`.`trips`
        JOIN `mydb`.`locations` ON ((`mydb`.`trips`.`locations_location_id` = `mydb`.`locations`.`location_id`)))
        JOIN `mydb`.`packages` ON ((`mydb`.`trips`.`packages_package_id` = `mydb`.`packages`.`package_id`)))
        JOIN `mydb`.`countries` ON ((`mydb`.`locations`.`countries_country_id` = `mydb`.`countries`.`country_id`)))