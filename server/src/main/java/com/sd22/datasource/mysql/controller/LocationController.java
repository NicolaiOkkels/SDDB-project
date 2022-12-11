package com.sd22.datasource.mysql.controller;

import com.sd22.datasource.mysql.entity.Location;
import com.sd22.datasource.mysql.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LocationController {
    @Autowired
    LocationService locationService;

    //Get all locations
    @GetMapping("/")
    public ResponseEntity<List<Location>> getLocations() {
        List<Location> locations = locationService.getLocations();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    //Add a Location
    @PostMapping("/add")
    public ResponseEntity<Location> addLocation(@RequestBody Location location) {
        Location newLocation = locationService.addLocation(location);
        return new ResponseEntity<>(newLocation,HttpStatus.CREATED);
    }

    //Find location by id
    @GetMapping("/{id}")
    public ResponseEntity<Location> findLocationById(@PathVariable int id) {
        Location location = locationService.findLocationById(id);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    //DELETE location by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Location> delete(@PathVariable("id") int id) {
        locationService.deleteLocationById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //PUT, update by id
    @PutMapping("/update")
    public ResponseEntity<Location> update(@RequestBody Location location) {
        Location updateLocation = locationService.updateLocation(location);
        return new ResponseEntity<>(updateLocation, HttpStatus.OK);
    }
}
