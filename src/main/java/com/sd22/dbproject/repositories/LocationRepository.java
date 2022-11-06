package com.sd22.dbproject.repositories;

import com.sd22.dbproject.models.Location;
import com.sd22.dbproject.models.User;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Integer> {
}
