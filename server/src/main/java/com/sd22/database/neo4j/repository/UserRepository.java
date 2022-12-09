package com.sd22.database.neo4j.repository;

import com.sd22.database.neo4j.entity.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserRepository extends Neo4jRepository<User, String> {
}
