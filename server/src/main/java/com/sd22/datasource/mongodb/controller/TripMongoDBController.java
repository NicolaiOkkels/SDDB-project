package com.sd22.datasource.mongodb.controller;

import com.sd22.datasource.mongodb.entity.Trip;
import com.sd22.datasource.mongodb.service.TripMongoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RestController
@RequestMapping("/mongo/trips")
public class TripMongoDBController {

    @Autowired
    TripMongoDBService tripMongoDBService;

    @Autowired
    public TripMongoDBController(TripMongoDBService tripMongoDBService){
        this.tripMongoDBService = tripMongoDBService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Trip>> getAllTrips() {
        try {
            List<Trip> trips = new ArrayList<>();
            trips.addAll(tripMongoDBService.findAll());

            if (trips.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(trips, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Trip> addTrip(@RequestBody Trip trip) {
        try {
            Trip tripSaved = tripMongoDBService.save(trip);
            return new ResponseEntity<>(tripSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable("id") String id, @RequestBody Trip trip) {
        Optional<Trip> tripData = Optional.ofNullable(tripMongoDBService.findTripById(id));

        if (tripData.isPresent()) {
            Trip _trip = tripData.get();
            _trip.setPrice(trip.getPrice());
            _trip.setDescription(trip.getDescription());
            _trip.setAvailabilty(trip.getAvailabilty());
            _trip.setLength(trip.getLength());
            _trip.setTitle(trip.getTitle());
            _trip.setRatingTotal(_trip.getRatingTotal());
            return new ResponseEntity<>(tripMongoDBService.updateTrip(_trip), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> findTripById(@PathVariable String id) {
        try {
        Trip trip = tripMongoDBService.findTripById(id);
        return new ResponseEntity<>(trip, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Trip> deleteTripById(@PathVariable("id") String id) {
        try {
        tripMongoDBService.deleteTripById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
}