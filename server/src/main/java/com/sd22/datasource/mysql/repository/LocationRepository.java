package com.sd22.datasource.mysql.repository;

import com.sd22.datasource.mysql.entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {
}
