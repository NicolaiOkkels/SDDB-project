package com.sd22.datasource.neo4j.repository;

import com.sd22.datasource.neo4j.entity.Trip;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripNeo4jRepository extends Neo4jRepository<Trip, Long> {
}
