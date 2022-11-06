package com.sd22.dbproject.repositories;

import com.sd22.dbproject.models.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {
}
