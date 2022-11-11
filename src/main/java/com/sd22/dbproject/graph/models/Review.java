package com.sd22.dbproject.graph.models;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.util.Date;

@Node
public class Review {

    @Id
    private String title;

    @Property("rating")
    private final Integer rating;

    @Property("visit")
    private final Date visitDate;

    @Property("text")
    private final String text;

    public Review(String title, Integer rating, Date visitDate, String text) {
        this.title = title;
        this.rating = rating;
        this.visitDate = visitDate;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public Integer getRating() {
        return rating;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public String getText() {
        return text;
    }
}
