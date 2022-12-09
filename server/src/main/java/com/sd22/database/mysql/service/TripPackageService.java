package com.sd22.database.mysql.service;

import com.sd22.database.mysql.entity.TripPackage;
import com.sd22.database.mysql.repository.TripPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TripPackageService {
    @Autowired
    private TripPackageRepository tripPackageRepository;

    public List<TripPackage> getTripPackages() {
        List<TripPackage> tripPackages = new ArrayList<>();
        tripPackageRepository.findAll().forEach(tripPackages::add);
        return tripPackages;
    }

    public void addTripPackage(TripPackage tripPackage) {
        tripPackageRepository.save(tripPackage);
    }

    public Optional<TripPackage> findTripPackageById(int id) {
        return tripPackageRepository.findById(id);
    }

    public void deleteTripPackageById(int id) {
        tripPackageRepository.deleteById(id);
    }

    public TripPackage updateTripPackage(TripPackage tripPackage){
        return tripPackageRepository.save(tripPackage);
    }

}