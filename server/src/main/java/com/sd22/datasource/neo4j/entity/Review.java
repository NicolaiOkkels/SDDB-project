package com.sd22.datasource.neo4j.entity;

import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Node
public class Review {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private double rating;
    private String visit;
    private String text;

    @Relationship(type = "WROTE", direction = Relationship.Direction.INCOMING)
    private User user;

    @Relationship(type = "REVIEWED", direction = Relationship.Direction.INCOMING)
    private Trip trip;

    public Review(String title, double rating, String text) {
        this.title = title;
        this.rating = rating;
        this.text = text;
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

    public double getRating() {
        return rating;
    }

    public String getVisit() {
        return visit;
    }

    public String getText() {
        return text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setVisit(String visit) {
        this.visit = visit;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
