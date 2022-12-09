package com.sd22.database.neo4j.controller;

import com.sd22.database.neo4j.entity.Trip;
import com.sd22.database.neo4j.service.TripService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/neo4j/trip")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/trips")
    public List<Trip> getAll(){
        return tripService.getAll();
    }

    @PostMapping("/trips")
    public Trip createTrip(@RequestParam Trip trip){
        return tripService.save(trip);
    }

    @DeleteMapping("/delete")
    public void deleteTrip(@RequestParam("title") String title){
        tripService.delete(title);
    }
}
