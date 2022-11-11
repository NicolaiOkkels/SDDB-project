package com.sd22.dbproject.relational.repositories;

import com.sd22.dbproject.relational.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
