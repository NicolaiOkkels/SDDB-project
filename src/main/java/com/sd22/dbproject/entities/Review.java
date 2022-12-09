package com.sd22.dbproject.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
@ToString
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

    public Review(String title, int rating, Date visitDate, String text) {
        this.title = title;
        this.rating = rating;
        this.visitDate = visitDate;
        this.text = text;
    }
}
