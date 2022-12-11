package com.sd22.datasource.mysql.repository;

import com.sd22.datasource.mysql.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
}
