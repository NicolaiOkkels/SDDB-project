package com.sd22.datasource.mongodb.controller;

import com.sd22.datasource.mongodb.entity.Trip;
import com.sd22.datasource.mongodb.service.TripMongoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/rest/mongo")
public class TripMongoDBController {

    @Autowired
    TripMongoDBService tripMongoDBService;

    @Autowired
    public TripMongoDBController(TripMongoDBService tripMongoDBService){
        this.tripMongoDBService = tripMongoDBService;
    }

    @GetMapping("/trips")
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

    @PostMapping("/trips")
    public ResponseEntity<Trip> addTrip(@RequestBody Trip trip) {
        try {
            Trip tripSaved = tripMongoDBService.save(trip);
            return new ResponseEntity<>(tripSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}