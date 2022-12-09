package com.sd22.dbproject.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tripId;
    private String description;
    private double price;
    private String length;
    private String title;
    private String availabilty;
    private Double ratingTotal;

    public Trip(String description, double price, String length, String title, String availabilty, Double ratingTotal,
                Location location, List<Review> reviews) {
        this.description = description;
        this.price = price;
        this.length = length;
        this.title = title;
        this.availabilty = availabilty;
        this.ratingTotal = ratingTotal;
    }
}
