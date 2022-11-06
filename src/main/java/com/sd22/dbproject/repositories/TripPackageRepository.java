package com.sd22.dbproject.repositories;

import com.sd22.dbproject.models.TripPackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripPackageRepository extends CrudRepository<TripPackage, Integer> {
}
