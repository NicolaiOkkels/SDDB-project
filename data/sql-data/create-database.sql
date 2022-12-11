DROP DATABASE IF EXISTS `SDDB`;

CREATE DATABASE `SDDB`;
USE `SDDB`;
SET NAMES utf8;
SET SQL_SAFE_UPDATES = 0;

CREATE TABLE `countries` (
                             `id` INT NOT NULL AUTO_INCREMENT,
                             `name` VARCHAR(255) NOT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT = 5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `countries` VALUES (1, 'Denmark');
INSERT INTO `countries` VALUES (2, 'United States');
INSERT INTO `countries` VALUES (3, 'Spain');
INSERT INTO `countries` VALUES (4, 'Greece');

CREATE TABLE `locations` (
                             `id` INT NOT NULL AUTO_INCREMENT,
                             `name` VARCHAR(255) NOT NULL,
                             `country_id` INT NOT NULL,
                             PRIMARY KEY (`id`, `country_id`),
                             INDEX `fk_locations_countries_idx` (`country_id` ASC) VISIBLE,
                             CONSTRAINT `fk_locations_countries` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT = 7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `locations` VALUES (1, 'New York City', 2);
INSERT INTO `locations` VALUES (2, 'Grand Canyon', 2);
INSERT INTO `locations` VALUES (3, 'Yellowstone', 2);
INSERT INTO `locations` VALUES (4, 'Copenhagen', 1);
INSERT INTO `locations` VALUES (5, 'Barcelonas Sagrada Familia and Gaudi sites', 3);
INSERT INTO `locations` VALUES (6, 'Knossos, Crete', 4);

CREATE TABLE `trips` (
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `description` VARCHAR(500) NOT NULL,
                         `price` DECIMAL(9,2) NOT NULL,
                         `duration` VARCHAR(255) NULL,
                         `title` VARCHAR(255) NOT NULL,
                         `availability` VARCHAR(255) NOT NULL,
                         `rating_total` DECIMAL(2,1) NULL,
                         `location_id` INT NULL,
                         PRIMARY KEY (`id`),
                         INDEX `fk_trips_locations_idx` (`location_id` ASC) VISIBLE,
                         CONSTRAINT `fk_trips_locations` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT = 6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `trips` VALUES (1, 'tbd', 150.00, 'Between 1-2 hours', 'The little mermaid in Copenhagen', 'everyday', 4, 4);
INSERT INTO `trips` VALUES (2, 'tbd', 75.00, 'Between 1-2 hours', 'The statue of liberty', 'everyday', 1, 2);
INSERT INTO `trips` VALUES (3, 'tbd', 0.00, '1 hour', 'Central Park', 'everyday', 1, 2);
INSERT INTO `trips` VALUES (4, 'tbd', 200.00, 'Between 3-4 hours', 'Metropolitan Museum of Art', 'All days exept Wednesday, from 10-17 on weekdays & 10-21 Friday, Saturday', 1, 2);
INSERT INTO `trips` VALUES (5, 'tbd', 299.99, 'Around 2 hours', 'Knossos archeologial site', 'Tuesday & Thursday between 10-21', 6, 3);

CREATE TABLE `users` (
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `email` VARCHAR(255) NOT NULL,
                         `password` VARCHAR(32) NOT NULL,
                         `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
                         PRIMARY KEY (`id`),
                         UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE
) ENGINE=InnoDB AUTO_INCREMENT = 7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `users` VALUES (1, 'admin123@gmail.com', '12345', CURRENT_TIMESTAMP);
INSERT INTO `users` VALUES (2, 'Lynn_Rehman5192@twipet.com', 'noonewillguessthis', CURRENT_TIMESTAMP);
INSERT INTO `users` VALUES (3, 'Barry_Moore9181@nickia.com', 'notapassword', CURRENT_TIMESTAMP);
INSERT INTO `users` VALUES (4, 'Bob_Bob123@live.dk', 'randomword', CURRENT_TIMESTAMP);
INSERT INTO `users` VALUES (5, 'test', 'password', CURRENT_TIMESTAMP);
INSERT INTO `users` VALUES (6, 'admin', 'admin', CURRENT_TIMESTAMP);

CREATE TABLE `roles` (
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `name` VARCHAR(45) NOT NULL,
                         PRIMARY KEY (`id`)
);

CREATE TABLE `users_roles` (
                               `user_id` INT NOT NULL,
                               `role_id` INT NOT NULL,
                               INDEX `user_fk_idx` (`user_id`),
                               INDEX `role_fk_idx` (`role_id`),
                               CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
                               CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);

INSERT INTO `roles` VALUES (1,'USER');
INSERT INTO `roles` VALUES (2, 'ADMIN');

INSERT INTO `users_roles` VALUES (1, 1);
INSERT INTO `users_roles` VALUES (2, 1);
INSERT INTO `users_roles` VALUES (3, 1);
INSERT INTO `users_roles` VALUES (4, 1);
INSERT INTO `users_roles` VALUES (5, 1);
INSERT INTO `users_roles` VALUES (6, 1);
INSERT INTO `users_roles` VALUES (6, 2);

CREATE TABLE `reviews` (
                           `id` INT NOT NULL AUTO_INCREMENT,
                           `title` VARCHAR(255) NOT NULL,
                           `rating` INT NOT NULL,
                           `visit_date` DATE NOT NULL,
                           `text` VARCHAR(500) NULL,
                           `trip_id` INT NOT NULL,
                           `user_id` INT NOT NULL,
                           PRIMARY KEY (`id`, `trip_id`, `user_id`),
                           INDEX `fk_reviews_trips_idx` (`trip_id` ASC) VISIBLE,
                           INDEX `fk_reviews_user_idx` (`user_id` ASC) VISIBLE,
                           CONSTRAINT `fk_reviews_trips` FOREIGN KEY (`trip_id`) REFERENCES `trips` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
                           CONSTRAINT `fk_reviews_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT = 5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `reviews` VALUES (1, 'Super exciting tour in New York', '5', '2020-05-01', 'We got picked up at the hotel by the guide....tbd',2 ,1);
INSERT INTO `reviews` VALUES (2, 'Worst trip ever, would not recommend', '2', '2022-05-01', 'the guide was bad',2 ,2);
INSERT INTO `reviews` VALUES (3, 'Hyggelig tur til københavn', '5', '2022-04-21', 'tbd',1 ,3);
INSERT INTO `reviews` VALUES (4, 'Exceptional tour to knossos', '4', '2021-04-11', 'tbd',5 ,1);

CREATE TABLE `tags` (
                        `id` INT NOT NULL AUTO_INCREMENT,
                        `name` VARCHAR(30) NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT = 9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `tags` VALUES (1, 'Outdoors');
INSERT INTO `tags` VALUES (2, 'Food & Drink');
INSERT INTO `tags` VALUES (3, 'Art & Culture');
INSERT INTO `tags` VALUES (4, 'By the water');
INSERT INTO `tags` VALUES (5, 'Nature');
INSERT INTO `tags` VALUES (6, 'City');
INSERT INTO `tags` VALUES (7, 'Best seller');
INSERT INTO `tags` VALUES (8, 'groups');