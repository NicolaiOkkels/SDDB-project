package com.sd22.datasource.config;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.neo4j.Neo4jAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.core.DatabaseSelectionProvider;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.data.neo4j.core.mapping.Neo4jMappingContext;
import org.springframework.data.neo4j.core.transaction.Neo4jTransactionManager;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.sd22.datasource.neo4j.repository", transactionManagerRef = "neo4jTransactionManager")
@EnableTransactionManagement
public class Neo4jConfig extends Neo4jAutoConfiguration {

    @Value("${spring.neo4j.uri}")
    private String neo4jUri;

    @Value("${spring.neo4j.authentication.username}")
    private String username;

    @Value("${spring.neo4j.authentication.password}")
    private String password;

    @Bean
    public Driver getConfiguration(){
          return GraphDatabase.driver(neo4jUri, AuthTokens.basic(username, password));
    }

    @Bean(name = "neo4jTransactionManager")
    public Neo4jTransactionManager neo4jTransactionManager(){
        return new Neo4jTransactionManager(getConfiguration());
    }

    @Bean("neo4jClient")
    public Neo4jClient neo4jClient(DatabaseSelectionProvider databaseSelectionProvider){
          return Neo4jClient.create(getConfiguration(), databaseSelectionProvider);
    }

    @Bean("neo4jTemplate")
    public Neo4jTemplate neo4jTemplate(@Qualifier("neo4jClient") Neo4jClient neo4jClient, Neo4jMappingContext neo4jMappingContext){
           return new Neo4jTemplate(neo4jClient, neo4jMappingContext);
    }

}
