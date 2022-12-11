package com.sd22.datasource.neo4j.service;

import com.sd22.datasource.neo4j.repository.TripNeo4jRepository;
import com.sd22.datasource.neo4j.entity.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TripNeo4jService {

    @Autowired
    private TripNeo4jRepository tripNeo4jRepository;

    @Transactional("neo4jTransactionManager")
    public List<Trip> getAll(){
        return tripNeo4jRepository.findAll();
    }

    @Transactional("neo4jTransactionManager")
    public Optional<Trip> getTripById(Long id) {
        return tripNeo4jRepository.findById(id);
    }

    @Transactional("neo4jTransactionManager")
    public void delete(Long id){
        tripNeo4jRepository.deleteById(id);
    }

    @Transactional("neo4jTransactionManager")
    public Trip save(Trip trip){
        return tripNeo4jRepository.save(trip);
    }
}
