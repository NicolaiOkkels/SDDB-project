package com.sd22.datasource.mysql.controller;

import com.sd22.datasource.mysql.entity.Country;
import com.sd22.datasource.mysql.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CountryController {
    @Autowired
    private CountryService countryService;

    //Get all countries
    @GetMapping("/")
    public ResponseEntity<List<Country>> getCountries() {
        List<Country> countries = countryService.getCountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    //Add a country
    @PostMapping("/add")
    public ResponseEntity<Country> addCountry(@RequestBody Country country) {
        Country newCountry = countryService.addCountry(country);
        return new ResponseEntity<>(newCountry,HttpStatus.CREATED);
    }

    //Find country by id
    @GetMapping("/{id}")
    public ResponseEntity<Country> findCountryById(@PathVariable int id) {
        Country country = countryService.findCountryById(id);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    //DELETE country by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Country> delete(@PathVariable("id") int id) {
        countryService.deleteCountryById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //PUT,update by id
    @PutMapping("/update")
    public ResponseEntity<Country> update(@RequestBody Country country) {
        Country updateCountry = countryService.updateCountry(country);
        countryService.updateCountry(country);
        return new ResponseEntity<>(updateCountry, HttpStatus.OK);
    }
}
