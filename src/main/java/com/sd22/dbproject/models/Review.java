package com.sd22.dbproject.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    private String title;
    private int rating;
    private Date visitDate;
    private String text;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private User user;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "trips_trip_id")
    private Trip trip;

    public Review() {
    }

    public Review(String title, int rating, Date visitDate, String text, User user, Trip trip) {
        this.title = title;
        this.rating = rating;
        this.visitDate = visitDate;
        this.text = text;
        this.user = user;
        this.trip = trip;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getText() {
        return text;
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

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", visitDate=" + visitDate +
                ", text='" + text + '\'' +
                ", user=" + user +
                ", trip=" + trip +
                '}';
    }
}
