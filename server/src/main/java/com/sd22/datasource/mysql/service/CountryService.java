package com.sd22.datasource.mysql.service;

import com.sd22.datasource.mysql.entity.Country;
import com.sd22.datasource.mysql.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getCountries() {
        List<Country> countries = new ArrayList<>();
        countryRepository.findAll().forEach(countries::add);
        return countries;
    }

    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    public Optional<Country> findCountryById(int id) {
        return countryRepository.findById(id);
    }

    public void deleteCountryById(int id) {
        countryRepository.deleteById(id);
    }

    public Country updateCountry(Country country){
        return countryRepository.save(country);
    }
}
