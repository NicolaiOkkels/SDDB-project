package com.sd22.datasource.mongodb.service;

import com.sd22.datasource.mongodb.entity.Trip;
import com.sd22.datasource.mongodb.repository.TripMongoDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TripMongoDBService {

    TripMongoDBRepository tripMongoDBRepository;

    @Autowired
    public TripMongoDBService(TripMongoDBRepository tripMongoDBRepository){
        this.tripMongoDBRepository = tripMongoDBRepository;
    }

    public Trip save(Trip trip) {
        return tripMongoDBRepository.save(trip);
    }

    public Collection<? extends Trip> findAll() {
       return tripMongoDBRepository.findAll();
    }
}
