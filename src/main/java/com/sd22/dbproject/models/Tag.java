package com.sd22.dbproject.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tagId;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "package_tags",
            joinColumns = @JoinColumn(name = "tags_tag_id", referencedColumnName = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "packages_package_id", referencedColumnName = "package_id"))

    private List<TripPackage> tripPackages;

    @ManyToMany
    @JoinTable(
            name = "trip_tags",
            joinColumns = @JoinColumn(name = "tags_tag_id", referencedColumnName = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "trips_trip_id", referencedColumnName = "trip_id"))

    private List<Trip> trips;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public List<TripPackage> getTripPackages() {
        return tripPackages;
    }

    public void setTripPackages(List<TripPackage> tripPackages) {
        this.tripPackages = tripPackages;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", name='" + name + '\'' +
                '}';
    }
}
