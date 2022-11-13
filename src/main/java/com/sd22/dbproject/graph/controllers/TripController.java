package com.sd22.dbproject.graph.controllers;

import com.sd22.dbproject.graph.entities.Trip;
import com.sd22.dbproject.graph.repositories.TripRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/trips")
public class TripController {
    private final TripRepository tripRepository;
    public TripController(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @GetMapping(value = { "", "/" }, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Trip> getTrips() {
        return tripRepository.findAll();
    }

    @GetMapping("/by-title")
    Mono<Trip> tripByTitle(@RequestParam String title) {
        return tripRepository.findOneByTitle(title);
    }
}
