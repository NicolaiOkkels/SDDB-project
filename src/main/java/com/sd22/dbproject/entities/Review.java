package com.sd22.dbproject.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    public Review() {
    }

    public Review(String title, int rating, Date visitDate, String text) {
        this.title = title;
        this.rating = rating;
        this.visitDate = visitDate;
        this.text = text;
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

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", visitDate=" + visitDate +
                ", text='" + text + '\'' +
                '}';
    }
}
