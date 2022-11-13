package com.sd22.dbproject.relational.repositories;

import com.sd22.dbproject.relational.entities.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {
}
