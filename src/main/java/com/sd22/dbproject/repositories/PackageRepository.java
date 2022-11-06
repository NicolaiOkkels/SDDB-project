package com.sd22.dbproject.repositories;

import com.sd22.dbproject.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends CrudRepository<Package, Integer> {
}
