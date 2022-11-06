package com.sd22.dbproject.services;

import com.sd22.dbproject.models.Trip;
import com.sd22.dbproject.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    public List<Trip> getTrips() {
        List<Trip> trips = new ArrayList<>();
        tripRepository.findAll().forEach(trips::add);
        return trips;
    }

    public void addUser(Trip trip) {
        tripRepository.save(trip);
    }

    public Optional<Trip> findTripById(int id) {
        return tripRepository.findById(id);
    }

    public void deleteTripById(int id) {
        tripRepository.deleteById(id);
    }
}
