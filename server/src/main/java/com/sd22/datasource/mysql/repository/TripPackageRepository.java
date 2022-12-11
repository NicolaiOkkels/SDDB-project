package com.sd22.datasource.mysql.repository;

import com.sd22.datasource.mysql.entity.TripPackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripPackageRepository extends CrudRepository<TripPackage, Integer> {
}
