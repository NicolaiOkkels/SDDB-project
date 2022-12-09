package com.sd22.database.neo4j.service;

import com.sd22.database.neo4j.repository.TripRepository;
import com.sd22.database.neo4j.entity.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public List<Trip> getAll(){
        return tripRepository.findAll();
    }

    public void delete(String title){
        tripRepository.deleteById(title);
    }

    public Trip save(Trip trip){
        return tripRepository.save(trip);
    }
}
