package com.sd22.datasource.neo4j.controller;
import com.sd22.datasource.neo4j.entity.Trip;
import com.sd22.datasource.neo4j.service.TripNeo4jService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/rest/neo4j/trip")
public class TripNeo4jController {

    private final TripNeo4jService tripNeo4jService;

    public TripNeo4jController(TripNeo4jService tripNeo4jService) {
        this.tripNeo4jService = tripNeo4jService;
    }

    @GetMapping("/trips")
    public List<Trip> getAll(){
        return tripNeo4jService.getAll();
    }

    @GetMapping("/")
    public Trip getTripById(@RequestParam("id") String id){
        Optional<Trip> tripOpt = tripNeo4jService.getTripById(Long.parseLong(id));
        if(tripOpt.isPresent()){
            return tripOpt.get();
        }
        throw new NoSuchElementException("No trip found with given id");
    }

    @PostMapping("/trips")
    public Trip createTrip(@RequestParam Trip trip){
        return tripNeo4jService.save(trip);
    }

    @DeleteMapping("/delete")
    public void deleteTrip(@RequestParam("id") String id){
        tripNeo4jService.delete(Long.parseLong(id));
    }
}
