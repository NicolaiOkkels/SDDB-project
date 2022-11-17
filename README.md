# SDDB-project

## Installation procedure for setup of database in test environment

1. Setup MySql connection, with docker by running this command:
   docker run -d --name mysqldb -p 3307:3306 -e MYSQL_ROOT_PASSWORD=123456 -h127.0.0.1 mysql:latest

2. Open MySQL Workbench

3. Connect to the MySQL connection

4. Open script file create-database.sql and execute the file to create the database

5. Open and execute the remaining script files:
   - events.sql
   - ratingAverageByUserId.sql
   - getRatingByLevel.sql
   - getRatingsByUser.sql
   - getTitleAndRating.sql
   - triggers.sql 
   - trip_view.sql

6. Open the application in the IDE of preference

7. Run the application & go to the URL: localhost:8080 for the test environment, login with a test user, here is an example: 
 - username: test
 - password: password

8. For testing of endpoints go to localhost:8080/swagger-ui

