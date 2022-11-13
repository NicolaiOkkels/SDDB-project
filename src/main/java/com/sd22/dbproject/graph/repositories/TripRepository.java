package com.sd22.dbproject.graph.repositories;

import com.sd22.dbproject.graph.entities.Trip;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import reactor.core.publisher.Mono;


public interface TripRepository extends ReactiveNeo4jRepository<Trip, String> {
        Mono<Trip> findOneByTitle(String title);
}
