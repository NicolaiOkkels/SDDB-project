package com.sd22.database.mysql.controller;

import com.sd22.database.mysql.entity.TripPackage;
import com.sd22.database.mysql.service.TripPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/packages")
public class TripPackageController {
    @Autowired
    private TripPackageService tripPackageService;

    //Get all packages
    @GetMapping("/")
    public List<TripPackage> getTripPackage() {
        return tripPackageService.getTripPackages();
    }

    //Add a package
    @PostMapping("/add")
    public void addPackage(@RequestBody TripPackage tripPackage) {
        tripPackageService.addTripPackage(tripPackage);
    }

    //Find package by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<TripPackage>> findTripPackageById(@PathVariable int id) {
        Optional<TripPackage> tripPackage = tripPackageService.findTripPackageById(id);
        if (tripPackage.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(tripPackage);
        } else {
            return ResponseEntity.ok(tripPackage);
        }
    }

    //DELETE package by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        Optional<TripPackage> tripPackage = tripPackageService.findTripPackageById(id);
        if (tripPackage.isEmpty()) {
            //id does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'msg' : 'package " + id + " not found'}");
        }
        tripPackageService.deleteTripPackageById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("{ 'msg' : 'deleted' }");
    }

    //PUT,update package by id
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody TripPackage requestPackage) {
        Optional<TripPackage> tripPackage = tripPackageService.findTripPackageById(id);
        if (tripPackage.isEmpty()) {
            //id does not exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'msg' : 'package " + id + " not found'}");
        }
        tripPackageService.updateTripPackage(requestPackage);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("{ 'msg' : 'updated' }");
    }
}
