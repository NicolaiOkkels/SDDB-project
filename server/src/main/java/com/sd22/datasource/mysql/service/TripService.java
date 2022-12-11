package com.sd22.datasource.mysql.service;

import com.sd22.datasource.mysql.entity.Trip;
import com.sd22.datasource.mysql.repository.TripRepository;
import com.sd22.datasource.mysql.service.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    public List<Trip> getTrips() {
        List<Trip> trips = new ArrayList<>();
        tripRepository.findAll().forEach(trips::add);
        return trips;
    }

    public Trip addTrip(Trip trip) {
       return tripRepository.save(trip);
    }

    public Trip findTripById(int id) {
        return tripRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteTripById(int id) {
        tripRepository.deleteById(id);
    }

    public Trip updateTrip(Trip trip){
        return tripRepository.save(trip);
    }
}
