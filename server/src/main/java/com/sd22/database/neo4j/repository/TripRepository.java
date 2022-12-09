package com.sd22.database.neo4j.repository;

import com.sd22.database.neo4j.entity.Trip;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends Neo4jRepository<Trip, String> {
}
