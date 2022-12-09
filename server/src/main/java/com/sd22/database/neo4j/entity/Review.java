package com.sd22.database.neo4j.entity;

import org.springframework.data.neo4j.core.schema.*;

import java.util.Date;

@Node
public class Review {

    @Id
    private String title;

    private int rating;

    private Date visitDate;

    private String text;

    @Relationship(type = "REVIEWED_BY", direction = Relationship.Direction.INCOMING)
    private User user;

    @Relationship(type = "REVIEW_IN", direction = Relationship.Direction.INCOMING)
    private Trip trip;

    public Review(String title, int rating, String text) {
        this.title = title;
        this.rating = rating;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }

    public Date getVisitDate() {
        return visitDate;
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

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }
}
