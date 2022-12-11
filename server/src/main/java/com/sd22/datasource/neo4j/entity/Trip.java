package com.sd22.datasource.neo4j.entity;

import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Node
public class Trip {

    @Id
    @GeneratedValue
    private Long id;

    private final String title;

    private final String description;

    private double price;

    private String duration;

    private String availability;

    private Double rating;

    @Relationship(type = "REVIEWED", direction = Relationship.Direction.INCOMING)
    private List<Review> reviews;

    @Relationship(type = "TAGGED", direction = Relationship.Direction.INCOMING)
    private List<Tag> tags;

    public Trip(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
