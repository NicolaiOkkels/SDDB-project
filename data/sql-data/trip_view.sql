VIEW `SDDB`.`trip_view` AS
    SELECT 
        `SDDB`.`trips`.`title` AS `title`,
        `SDDB`.`trips`.`price` AS `price`,
        `SDDB`.`trips`.`description` AS `description`,
        `SDDB`.`trips`.`duration` AS `duration`,
        `SDDB`.`trips`.`availabilty` AS `availabilty`,
        `SDDB`.`locations`.`name` AS `location_name`,
        `SDDB`.`countries`.`name` AS `country_name`
    FROM
        (((`SDDB`.`trips`
        JOIN `SDDB`.`locations` ON ((`SDDB`.`trips`.`location_id` = `SDDB`.`locations`.`id`)))
        JOIN `SDDB`.`countries` ON ((`SDDB`.`locations`.`country_id` = `SDDB`.`countries`.`id`)))