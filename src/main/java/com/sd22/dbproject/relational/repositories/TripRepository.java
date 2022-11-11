package com.sd22.dbproject.relational.repositories;

import com.sd22.dbproject.relational.models.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends CrudRepository<Trip, Integer> {
}
