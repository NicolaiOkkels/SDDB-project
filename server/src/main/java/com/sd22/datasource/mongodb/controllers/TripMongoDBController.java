package com.sd22.datasource.mongodb.controllers;

import com.sd22.datasource.mongodb.entities.Trip;
import com.sd22.datasource.mongodb.services.TripMongoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/apimongo")
public class TripMongoDBController {

    @Autowired
    TripMongoDBService tripMongoDBService;

    @Autowired
    public TripMongoDBController(TripMongoDBService tripMongoDBService){
        this.tripMongoDBService = tripMongoDBService;
    }

    @GetMapping("/tripsmongo")
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

    @PostMapping("/tripsmongo")
    public ResponseEntity<Trip> addTrip(@RequestBody Trip trip) {
        try {
            Trip tripSaved = tripMongoDBService.save(trip);
            return new ResponseEntity<>(tripSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}