package com.sd22.dbproject.repositories;

import com.sd22.dbproject.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(value = "SELECT * FROM users u WHERE u.email = ?1", nativeQuery = true)
    Optional<User> findByUsername(String username);
}
