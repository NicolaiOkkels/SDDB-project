package com.sd22.dbproject.relational.services;

import com.sd22.dbproject.relational.repositories.LocationRepository;
import com.sd22.dbproject.relational.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getLocations() {
        List<Location> locations = new ArrayList<>();
        locationRepository.findAll().forEach(locations::add);
        return locations;
    }

    public void addLocation(Location location) {
        locationRepository.save(location);
    }

    public Optional<Location> findLocationById(int id) {
        return locationRepository.findById(id);
    }

    public void deleteLocationById(int id) {
        locationRepository.deleteById(id);
    }
    public Location updateLocation(Location location){
        return locationRepository.save(location);
    }
}
