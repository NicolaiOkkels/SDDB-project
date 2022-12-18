# SDDB-project

## Installation procedure for setup of database in test environment

1. Setup MySql connection, with docker by running this command:
   docker run -d --name mysqldb -p 3307:3306 -e MYSQL_ROOT_PASSWORD=123456 -h127.0.0.1 mysql:latest

   Setup MongoDB connection with docker running this command:
   docker run --name mongodb -d -p 27017:27017 mongo

   Setup Neo4j connection with docker running this command:
   docker run --name neo4j-docker --publish=7474:7475 --publish=7687:7688 --volume=C:/users/neo4j/data:/data --env=NEO4J_AUTH=none neo4j

2. Open MySQL Workbench, Neo4j application or 

3. Connect to the database by accessing the local database server on the port from the docker command

4. Open data dump file in the root folder data:

   sql-data -> create-database.sql and execute the file in to create the database

   neo4j-data -> ne4j.cypher and execute the file to create the database

   mongodb-data -> json files and execute the file to create the database

5. Open the application in the IDE of preference

6. Run the application & go to the URL: localhost:8080 for the test environment

7. For testing of endpoints go to localhost:8080/swagger-ui

