package com.sd22.dbproject.entities;

import javax.persistence.*;
import java.util.List;

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

    public Trip() {
    }

    public Trip(String description, double price, String length, String title, String availabilty, Double ratingTotal,
                Location location, List<Review> reviews) {
        this.description = description;
        this.price = price;
        this.length = length;
        this.title = title;
        this.availabilty = availabilty;
        this.ratingTotal = ratingTotal;
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
