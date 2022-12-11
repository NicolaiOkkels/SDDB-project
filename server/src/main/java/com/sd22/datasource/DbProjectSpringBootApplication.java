package com.sd22.datasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
//@EnableNeo4jRepositories
public class DbProjectSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbProjectSpringBootApplication.class, args);
    }

}
