package com.sd22.dbproject.controllers;

import com.sd22.dbproject.controllers.exceptions.UserNotFoundException;
import com.sd22.dbproject.models.Location;
import com.sd22.dbproject.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locations")
public class LocationController {
    @Autowired
    LocationService locationService;

    //Get all locations
    @GetMapping("/")
    public List<Location> getAllLocations(){
        return locationService.getLocations();
    }

    //Add a location
    @PostMapping("/add")
    public void addLocation(@RequestBody Location location){
        locationService.addLocation(location);
    }

    //Get location by id
    @GetMapping("/{id}")
    public Location findLocationById(@PathVariable int id) {
        try {
            Location location = locationService.findLocationById(id).orElseThrow(UserNotFoundException::new);
            if (location == null) {
                return (Location) ResponseEntity.status(HttpStatus.BAD_REQUEST);
            } else {
                return ResponseEntity.ok(location).getBody();
            }
        }catch(DataAccessException e){
            return (Location) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //DELETE location by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        Optional<Location> optionalLocation = locationService.findLocationById(id);
        if (!optionalLocation.isPresent()) {
            //id does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'msg' : 'location " + id + " not found'}");
        }
        locationService.deleteLocationById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("{ 'msg' : 'deleted' }");
    }
    //PUT,update by id
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody Location location) {
        Optional<Location> optionalLocation = locationService.findLocationById(id);
        if (!optionalLocation.isPresent()) {
            //id does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'msg' : 'location " + id + " not found'}");
        }
        locationService.updateLocation(location);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("{ 'msg' : 'updated' }");
    }

}
