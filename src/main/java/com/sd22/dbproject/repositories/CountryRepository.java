package com.sd22.dbproject.repositories;

import com.sd22.dbproject.models.Country;
import com.sd22.dbproject.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
}
