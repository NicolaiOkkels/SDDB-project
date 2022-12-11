package com.sd22.datasource.neo4j.repository;

import com.sd22.datasource.neo4j.entity.Review;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface ReviewNeo4jRepository extends Neo4jRepository<Review, Long> {

    @Query("MATCH (r:Review) WHERE r.rating < 2 RETURN r")
    List<Review> getBadReviews();
}
