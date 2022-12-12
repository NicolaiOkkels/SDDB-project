package com.sd22.datasource.mysql.service;

import com.sd22.datasource.mysql.entity.Location;
import com.sd22.datasource.mysql.repository.LocationRepository;
import com.sd22.datasource.mysql.service.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Transactional("mysqlTransactionManager")
    public List<Location> getLocations() {
        List<Location> locations = new ArrayList<>();
        locationRepository.findAll().forEach(locations::add);
        return locations;
    }

    @Transactional("mysqlTransactionManager")
    public Location addLocation(Location location) {
       return locationRepository.save(location);
    }

    @Transactional("mysqlTransactionManager")
    public Location findLocationById(int id) {
        return locationRepository.findById(id).orElseThrow(NotFoundException::new);
    }
    @Transactional("mysqlTransactionManager")
    public void deleteLocationById(int id) {
        locationRepository.deleteById(id);
    }

    @Transactional("mysqlTransactionManager")
    public Location updateLocation(Location location){
        return locationRepository.save(location);
    }
}
