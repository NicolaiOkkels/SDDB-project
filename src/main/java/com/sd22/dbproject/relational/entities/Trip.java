package com.sd22.dbproject.relational.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tripId;
    private String description;
    private double price;
    private String length;
    private String title;
    private String availabilty;
    private Double ratingTotal;

    //child backward
    @JsonBackReference
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "locations_location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "packages_package_id")
    private TripPackage tripPackage;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "trip_tags",
            joinColumns = @JoinColumn(name = "trips_trip_id"),
            inverseJoinColumns = @JoinColumn(name = "tags_tag_id"))
    private Set<Tag> tripTags;

    public Trip() {
    }

    public Trip(String description, double price, String length, String title, String availabilty, Double ratingTotal,
                Location location, TripPackage tripPackage, List<Review> reviews) {
        this.description = description;
        this.price = price;
        this.length = length;
        this.title = title;
        this.availabilty = availabilty;
        this.ratingTotal = ratingTotal;
        this.location = location;
        this.tripPackage = tripPackage;
        this.reviews = reviews;
    }

    public Set<Tag> getTags() {
        return tripTags;
    }

    public void setTags(Set<Tag> tags) {
        this.tripTags = tags;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvailabilty() {
        return availabilty;
    }

    public void setAvailabilty(String availabilty) {
        this.availabilty = availabilty;
    }

    public Double getRatingTotal() {
        return ratingTotal;
    }

    public void setRatingTotal(Double ratingTotal) {
        this.ratingTotal = ratingTotal;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripId=" + tripId +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", length='" + length + '\'' +
                ", title='" + title + '\'' +
                ", availabilty='" + availabilty + '\'' +
                ", ratingTotal=" + ratingTotal +
                '}';
    }
}
