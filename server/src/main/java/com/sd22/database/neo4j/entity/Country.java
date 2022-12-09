package com.sd22.database.neo4j.entity;

import com.sd22.database.mysql.entity.Location;
import org.springframework.data.neo4j.core.schema.*;

import java.util.HashSet;
import java.util.Set;

@Node
public class Country {

    @Id
    private final String name;

    @Relationship(type = "LOCATION_IN", direction = Relationship.Direction.INCOMING)
    private Set<Location> locations = new HashSet<>();

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }
}
