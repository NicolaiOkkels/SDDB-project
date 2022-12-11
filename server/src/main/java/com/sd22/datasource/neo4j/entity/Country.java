package com.sd22.datasource.neo4j.entity;

import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Node
public class Country {

    @Id
    @GeneratedValue
    private Long id;

    private final String name;

    @Relationship(type = "LOCATION_IN", direction = Relationship.Direction.INCOMING)
    private List<Location> locations;

    public Country(String name) {
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

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
