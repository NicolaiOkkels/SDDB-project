package com.sd22.datasource.mysql.repository;

import com.sd22.datasource.mysql.entity.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends CrudRepository<Trip, Integer> {
}
