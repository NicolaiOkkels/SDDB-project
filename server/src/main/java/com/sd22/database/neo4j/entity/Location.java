package com.sd22.database.neo4j.entity;

import org.springframework.data.neo4j.core.schema.*;

@Node
public class Location {

    @Id
    private final String name;

    @Relationship(type = "LOCATION_IN", direction = Relationship.Direction.INCOMING)
    private Country country;

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
