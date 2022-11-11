package com.sd22.dbproject.relational.repositories;

import com.sd22.dbproject.relational.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {
}
