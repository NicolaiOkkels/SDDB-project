package com.sd22.database.neo4j.repository;

import com.sd22.database.neo4j.entity.Review;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ReviewRepository extends Neo4jRepository<Review, String> {
}
