package com.sd22.dbproject.graph.models;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node
public class Trip {

    @Id
    private final String title;

    @Property("description")
    private final String description;

    @Property("price")
    private final double price;

    @Property("duration")
    private final String duration;

    @Property("availability")
    private final String availabilty;

    @Property("total_rating")
    private final Double totalRating;

    @Relationship(type = "REVIEWED", direction = Relationship.Direction.INCOMING)
    private final List<Review> reviews;

    @Relationship(type = "TAGGED", direction = Relationship.Direction.INCOMING)
    private final List<Tag> tags;

    public Trip(String title, String description, double price, String duration, String availabilty, Double totalRating, List<Review> reviews, List<Tag> tags) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.availabilty = availabilty;
        this.totalRating = totalRating;
        this.reviews = reviews;
        this.tags = tags;
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

    public String getAvailabilty() {
        return availabilty;
    }

    public Double getTotalRating() {
        return totalRating;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<Tag> getTags() {
        return tags;
    }
}
