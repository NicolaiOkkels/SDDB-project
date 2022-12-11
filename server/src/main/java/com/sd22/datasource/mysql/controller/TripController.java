package com.sd22.datasource.mysql.controller;

import com.sd22.datasource.mysql.entity.Trip;
import com.sd22.datasource.mysql.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TripController {

    @Autowired
    private TripService tripService;

    //Get all trips
    @GetMapping("/")
    public ResponseEntity<List<Trip>> getTrips() {
        List<Trip> trips = tripService.getTrips();
        return new ResponseEntity<>(trips, HttpStatus.OK);
    }

    //Add a trip
    @PostMapping("/add")
    public ResponseEntity<Trip> addTrip(@RequestBody Trip trip) {
        Trip newTrip = tripService.addTrip(trip);
        return new ResponseEntity<>(newTrip,HttpStatus.CREATED);
    }

    //Find trip by id
    @GetMapping("/{id}")
    public ResponseEntity<Trip> findTripById(@PathVariable int id) {
        Trip trip = tripService.findTripById(id);
        return new ResponseEntity<>(trip, HttpStatus.OK);
    }

    //DELETE trip by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Trip> delete(@PathVariable("id") int id) {
        tripService.deleteTripById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //PUT, update by id
    @PutMapping("/update")
    public ResponseEntity<Trip> update(@RequestBody Trip trip) {
        Trip updateTrip = tripService.updateTrip(trip);
        return new ResponseEntity<>(updateTrip, HttpStatus.OK);
    }
}
