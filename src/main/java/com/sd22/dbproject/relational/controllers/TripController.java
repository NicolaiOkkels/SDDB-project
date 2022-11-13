package com.sd22.dbproject.relational.controllers;

import com.sd22.dbproject.relational.entities.Trip;
import com.sd22.dbproject.relational.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trip")
public class TripController {

    @Autowired
    private TripService tripService;

    //Get all trips
    @GetMapping("/trips")
    public List<Trip> getTrips() {
        return tripService.getTrips();
    }

    //Add a trip
    @PostMapping("/addTrip")
    public void addTag(@RequestBody Trip trip) {
        tripService.addTrip(trip);
    }

    //Find trip by id
    @GetMapping("/trip/{id}")
    public ResponseEntity<Optional<Trip>> findCountryById(@PathVariable int id) {
        Optional<Trip> trip = tripService.findTripById(id);
        if (trip.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(trip);
        } else {
            return ResponseEntity.ok(trip);
        }
    }

    //DELETE trip by id
    @DeleteMapping("/tag/{id}")
    public ResponseEntity<Optional<Trip>> delete(@PathVariable("id") int id) {
        Optional<Trip> trip = tripService.findTripById(id);
        if (trip.isEmpty()) {
            //id does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(trip);
        }
        tripService.deleteTripById(id);

        return ResponseEntity.ok(trip);
    }

    //PUT,update by id
    @PutMapping("/tag/{id}")
    public ResponseEntity<Optional<Trip>> update(@PathVariable("id") int id, @RequestBody Trip requestTrip) {
        Optional<Trip> trip = tripService.findTripById(id);
        if (trip.isEmpty()) {
            //id does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(trip);
        }
        tripService.updateTrip(requestTrip);

        return ResponseEntity.ok(trip);
    }
}
