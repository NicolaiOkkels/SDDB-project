package com.sd22.datasource.neo4j.entity;

import org.springframework.data.neo4j.core.schema.*;

@Node
public class Location {

    @Id
    @GeneratedValue
    private Long id;

    private final String name;

    @Relationship(type = "OCCUR_AT", direction = Relationship.Direction.INCOMING)
    private Trip trip;

    public Location(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
