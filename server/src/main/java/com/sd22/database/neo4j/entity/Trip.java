package com.sd22.database.neo4j.entity;

import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;

@Node
public class Trip {

    @Id
    private final String title;

    private final String description;

    private double price;

    private String duration;

    private String availability;

    private Double rating;

    @Relationship(type = "REVIEWS", direction = Relationship.Direction.OUTGOING)
    private List<Review> reviews = new ArrayList<>();

    @Relationship(type = "TAGGED", direction = Relationship.Direction.OUTGOING)
    private List<Tag> tags = new ArrayList<>();

    @Relationship(type = "TRIP_AT", direction = Relationship.Direction.INCOMING)
    private Location location;

    public Trip(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getDuration() {
        return duration;
    }

    public String getAvailability() {
        return availability;
    }

    public Double getRating() {
        return rating;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
