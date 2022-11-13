package com.sd22.dbproject.relational.controllers;

import com.sd22.dbproject.relational.controllers.exceptions.UserNotFoundException;
import com.sd22.dbproject.relational.entities.Country;
import com.sd22.dbproject.relational.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    //Get all countries
    @RequestMapping("/allCountries")
    public List<Country> getAllCountries() {
        return countryService.getCountries();
    }

    //Add a country
    @PostMapping("/addCountry")
    public void addCountry(@RequestBody Country country) {
        countryService.addCountry(country);
    }

    //Find country by id
    @GetMapping("/countries/{id}")
    public Country findCountryById(@PathVariable int id) {
        try {
            Country country = countryService.findCountryById(id).orElseThrow(UserNotFoundException::new);
            if (country == null) {
                return (Country) ResponseEntity.status(HttpStatus.BAD_REQUEST);
            } else {
                return ResponseEntity.ok(country).getBody();
            }
        } catch (DataAccessException e) {
            return (Country) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //DELETE country by id
    @DeleteMapping("/countries/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        Optional<Country> optionalCountry = countryService.findCountryById(id);
        if (!optionalCountry.isPresent()) {
            //id does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'msg' : 'country " + id + " not found'}");
        }
        countryService.deleteCountryById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("{ 'msg' : 'deleted' }");
    }

    //PUT,update by id
    @PutMapping("/countries/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody Country country) {
        Optional<Country> optionalCountry = countryService.findCountryById(id);
        if (!optionalCountry.isPresent()) {
            //id does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'msg' : 'country " + id + " not found'}");
        }
        countryService.updateCountry(country);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("{ 'msg' : 'updated' }");
    }


}
