package com.sd22.datasource.mysql.service;

import com.sd22.datasource.mysql.entity.Country;
import com.sd22.datasource.mysql.repository.CountryRepository;
import com.sd22.datasource.mysql.service.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getCountries() {
        List<Country> countries = new ArrayList<>();
        countryRepository.findAll().forEach(countries::add);
        return countries;
    }

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country findCountryById(int id) {
        return countryRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteCountryById(int id) {
        countryRepository.deleteById(id);
    }

    public Country updateCountry(Country country){
        return countryRepository.save(country);
    }
}
