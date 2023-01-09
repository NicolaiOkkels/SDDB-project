package com.sd22.datasource.mongodb.entity;

import com.sd22.datasource.mysql.entity.Trip;
import com.sd22.datasource.mysql.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Document(collection = "reviews")
public class Review {
    @Id
    private String id;
    private String title;
    private int rating;
    private Date visitDate;
    private String text;
    private User user;
    private Trip trip;

    public Review(String id, String title, int rating, Date visitDate, String text, User user, Trip trip) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.visitDate = visitDate;
        this.text = text;
        this.user = user;
        this.trip = trip;
    }
}
