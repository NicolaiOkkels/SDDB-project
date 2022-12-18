package com.sd22.datasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableMongoRepositories( basePackages = "com.sd22.datasource.mongodb.repositories")
public class DbProjectSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbProjectSpringBootApplication.class, args);
    }

}
