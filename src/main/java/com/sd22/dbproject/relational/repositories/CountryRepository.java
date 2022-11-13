package com.sd22.dbproject.relational.repositories;

import com.sd22.dbproject.relational.entities.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
}
