package com.sd22.datasource.mongodb.service;

import com.sd22.datasource.mongodb.entity.Trip;
import com.sd22.datasource.mongodb.repository.TripMongoDBRepository;
import com.sd22.datasource.mysql.service.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Trip findTripById(String id) {
        return tripMongoDBRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteTripById(String id) {
        tripMongoDBRepository.deleteById(id);
    }

    public Trip updateTrip(Trip trip){
        return tripMongoDBRepository.save(trip);
    }
}
