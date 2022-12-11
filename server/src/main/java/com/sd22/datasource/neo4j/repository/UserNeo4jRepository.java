package com.sd22.datasource.neo4j.repository;

import com.sd22.datasource.neo4j.entity.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface UserNeo4jRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH (u:User)<-[a:ASSIGNED]-(r:Role) RETURN u,a,r")
    List<User> getUserRoles();
}
