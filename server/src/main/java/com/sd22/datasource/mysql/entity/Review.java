package com.sd22.datasource.mysql.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="reviews")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int rating;

    @Column(name = "visit_date")
    private Date visitDate;
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference("review_user")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference("review_trip")
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

    public int getId() {
        return id;
    }

    public void setId(int reviewId) {
        this.id = reviewId;
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
                "reviewId=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", visitDate=" + visitDate +
                ", text='" + text + '\'' +
                '}';
    }
}
