DROP DATABASE IF EXISTS `mydb`;

CREATE DATABASE `mydb`;
USE `mydb`;
SET NAMES utf8;
SET SQL_SAFE_UPDATES = 0;

CREATE TABLE `countries` (
  `country_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT = 5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
  
INSERT INTO `countries` VALUES (1, 'Denmark');
INSERT INTO `countries` VALUES (2, 'United States');
INSERT INTO `countries` VALUES (3, 'Spain');
INSERT INTO `countries` VALUES (4, 'Greece');

CREATE TABLE `locations` (
  `location_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `countries_country_id` INT NOT NULL,
  PRIMARY KEY (`location_id`, `countries_country_id`),
  INDEX `fk_locations_countries1_idx` (`countries_country_id` ASC) VISIBLE,
  CONSTRAINT `fk_locations_countries1` FOREIGN KEY (`countries_country_id`) REFERENCES `countries` (`country_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT = 7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
  
INSERT INTO `locations` VALUES (1, 'New York City', 2);
INSERT INTO `locations` VALUES (2, 'Grand Canyon', 2);
INSERT INTO `locations` VALUES (3, 'Yellowstone', 2);
INSERT INTO `locations` VALUES (4, 'Copenhagen', 1);
INSERT INTO `locations` VALUES (5, 'Barcelonas Sagrada Familia and Gaudi sites', 3);
INSERT INTO `locations` VALUES (6, 'Knossos, Crete', 4);
  
CREATE TABLE `packages` (
  `package_id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(500) NOT NULL,
  `price` DECIMAL(9,2) NOT NULL,
  `discount` DECIMAL(9,2) NULL,
  PRIMARY KEY (`package_id`)
) ENGINE=InnoDB AUTO_INCREMENT = 5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE EVENT package_summer_discount
	ON SCHEDULE AT '2023-06-22 23:59:59'
    DO UPDATE packages.discount
	SET packages.discount = package.discount * 1.4;

INSERT INTO `packages` VALUES (1, 'Famous locations in the United states', 5400.99, 500.00);
INSERT INTO `packages` VALUES (2, 'Tour in New York City', 3899.99, 350.00);
INSERT INTO `packages` VALUES (3, 'Referred to as Europes oldet city, Knossos is an archeologial site on Crete dating back to the bronze age', 3200.49, 399.99);
INSERT INTO `packages` VALUES (4, 'The famous & beautiful Scandinavial capital of denmark, Copenhagen', 2500.99, 200.00);

-- trip should be able to have no package
CREATE TABLE `trips` (
  `trip_id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(500) NOT NULL,
  `price` DECIMAL(9,2) NOT NULL,
  `length` VARCHAR(255) NULL,
  `title` VARCHAR(255) NOT NULL,
  `availabilty` VARCHAR(255) NOT NULL,
  `rating_total` DECIMAL(2,1) NULL,
  `locations_location_id` INT NOT NULL,
  `packages_package_id` INT NOT NULL,
  PRIMARY KEY (`trip_id`, `locations_location_id`, `packages_package_id`),
  INDEX `fk_trips_locations1_idx` (`locations_location_id` ASC) VISIBLE,
  INDEX `fk_trips_packages1_idx` (`packages_package_id` ASC) VISIBLE,
  CONSTRAINT `fk_trips_locations1` FOREIGN KEY (`locations_location_id`) REFERENCES `locations` (`location_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_trips_packages1` FOREIGN KEY (`packages_package_id`) REFERENCES `packages` (`package_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT = 6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `trips` VALUES (1, 'tbd', 150.00, 'Between 1-2 hours', 'The little mermaid in Copenhagen', 'everyday', null , 4, 4);
INSERT INTO `trips` VALUES (2, 'tbd', 75.00, 'Between 1-2 hours', 'The statue of liberty', 'everyday', null,1, 2);
INSERT INTO `trips` VALUES (3, 'tbd', 0.00, '1 hour', 'Central Park', 'everyday', null ,1, 2);
INSERT INTO `trips` VALUES (4, 'tbd', 200.00, 'Between 3-4 hours', 'Metropolitan Museum of Art', 'All days exept Wednesday, from 10-17 on weekdays & 10-21 Friday, Saturday', null, 1, 2);
INSERT INTO `trips` VALUES (5, 'tbd', 299.99, 'Around 2 hours', 'Knossos archeologial site', 'Tuesday & Thursday between 10-21', null, 6, 3);

-- user should have a name for the reviews
CREATE TABLE `users` (
  `user_id` INT NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE
) ENGINE=InnoDB AUTO_INCREMENT = 7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `users` VALUES (1, 'admin123@gmail.com', '12345', CURRENT_TIMESTAMP);
INSERT INTO `users` VALUES (2, 'Lynn_Rehman5192@twipet.com', 'noonewillguessthis', CURRENT_TIMESTAMP);
INSERT INTO `users` VALUES (3, 'Barry_Moore9181@nickia.com', 'notapassword', CURRENT_TIMESTAMP);
INSERT INTO `users` VALUES (4, 'Bob_Bob123@live.dk', 'randomword', CURRENT_TIMESTAMP);
INSERT INTO `users` VALUES (5, 'user', 'user', CURRENT_TIMESTAMP);
INSERT INTO `users` VALUES (6, 'admin', 'admin', CURRENT_TIMESTAMP);

CREATE TABLE `roles` (
    `role_id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`role_id`)
);

CREATE TABLE `users_roles` (
    `user_id` INT NOT NULL,
    `role_id` INT NOT NULL,
    INDEX `user_fk_idx` (`user_id`),
    INDEX `role_fk_idx` (`role_id`),
    CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
    CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
);

INSERT INTO `roles` (`name`) VALUES ('USER');
INSERT INTO `roles` (`name`) VALUES ('ADMIN');

-- reviews could have a create_time as user for when the review is created
-- maybe should rating be smallint or something else 
CREATE TABLE `reviews` (
  `review_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `rating` INT NOT NULL,
  `visit_date` DATE NOT NULL,
  `text` VARCHAR(500) NULL,
  `trips_trip_id` INT NOT NULL,
  `user_user_id` INT NOT NULL,
  PRIMARY KEY (`review_id`, `trips_trip_id`, `user_user_id`),
  INDEX `fk_reviews_trips1_idx` (`trips_trip_id` ASC) VISIBLE,
  INDEX `fk_reviews_user1_idx` (`user_user_id` ASC) VISIBLE,
  CONSTRAINT `fk_reviews_trips1` FOREIGN KEY (`trips_trip_id`) REFERENCES `trips` (`trip_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reviews_user1` FOREIGN KEY (`user_user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
  ) ENGINE=InnoDB AUTO_INCREMENT = 5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `reviews` VALUES (1, 'Super exciting tour in New York', '5', '2020-05-01', 'We got picked up at the hotel by the guide....tbd',2 ,1);
INSERT INTO `reviews` VALUES (2, 'Worst trip ever, would not recommend', '2', '2022-05-01', 'the guide was bad',2 ,2);
INSERT INTO `reviews` VALUES (3, 'Hyggelig tur til københavn', '5', '2022-04-21', 'tbd',1 ,3);
INSERT INTO `reviews` VALUES (4, 'Exceptional tour to knossos', '4', '2021-04-11', 'tbd',5 ,1);

CREATE TABLE `tags` (
  `tag_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`tag_id`)
  ) ENGINE=InnoDB AUTO_INCREMENT = 9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `tags` VALUES (1, 'Outdoors');
INSERT INTO `tags` VALUES (2, 'Food & Drink');
INSERT INTO `tags` VALUES (3, 'Art & Culture');
INSERT INTO `tags` VALUES (4, 'By the water');
INSERT INTO `tags` VALUES (5, 'Nature');
INSERT INTO `tags` VALUES (6, 'City');
INSERT INTO `tags` VALUES (7, 'Best seller');
INSERT INTO `tags` VALUES (8, 'groups');

CREATE TABLE `trip_tags` (
  `tags_tag_id` INT NOT NULL,
  `trips_trip_id` INT NOT NULL,
  `trips_locations_location_id` INT NOT NULL,
  `trips_packages_package_id` INT NULL,
  INDEX `fk_trip_tags_tags1_idx` (`tags_tag_id` ASC) VISIBLE,
  INDEX `fk_trip_tags_trips1_idx` (`trips_trip_id` ASC, `trips_locations_location_id` ASC, `trips_packages_package_id` ASC) VISIBLE,
  CONSTRAINT `fk_trip_tags_tags1` FOREIGN KEY (`tags_tag_id`) REFERENCES `tags` (`tag_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_trip_tags_trips1` FOREIGN KEY (`trips_trip_id` , `trips_locations_location_id` , `trips_packages_package_id`) REFERENCES `trips` (`trip_id` , `locations_location_id` , `packages_package_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
  
INSERT INTO `trip_tags` VALUES (1, 1, 4, null);
INSERT INTO `trip_tags` VALUES (1, 2, 1, 2);
INSERT INTO `trip_tags` VALUES (5, 2, 1, 2);
INSERT INTO `trip_tags` VALUES (5, 3, 1, 2);
INSERT INTO `trip_tags` VALUES (3, 4, 1, 2);
INSERT INTO `trip_tags` VALUES (5, 5, 6, 3);

CREATE TABLE `package_tags` (
  `tags_tag_id` INT NOT NULL,
  `packages_package_id` INT NOT NULL,
  INDEX `fk_package_tags_tags1_idx` (`tags_tag_id` ASC) VISIBLE,
  INDEX `fk_package_tags_packages1_idx` (`packages_package_id` ASC) VISIBLE,
  CONSTRAINT `fk_package_tags_tags1` FOREIGN KEY (`tags_tag_id`) REFERENCES `mydb`.`tags` (`tag_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_package_tags_packages1` FOREIGN KEY (`packages_package_id`) REFERENCES `mydb`.`packages` (`package_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
  
INSERT INTO `package_tags` VALUES (7, 1);
INSERT INTO `package_tags` VALUES (7, 2);
INSERT INTO `package_tags` VALUES (7, 3);
INSERT INTO `package_tags` VALUES (8, 4);