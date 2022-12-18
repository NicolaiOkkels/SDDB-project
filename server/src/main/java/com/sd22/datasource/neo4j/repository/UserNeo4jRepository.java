package com.sd22.datasource.neo4j.repository;

import com.sd22.datasource.neo4j.entity.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Optional;

public interface UserNeo4jRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH (u:User)<-[a:ASSIGNED]-(r:Role) RETURN u,a,r")
    List<User> getUserRoles();
    @Query("MATCH (u:User) u WHERE u.email = ?1")
    Optional<User> findByUsername(String username);
}
