package com.sd22.dbproject.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "countries_country_id")
    private Country country;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Trip> trips;

    public Location() {
    }

    public Location(String name) {
        this.name = name;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public int getLocationId() {
        return locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", name='" + name + '\'' +
                '}';
    }
}
