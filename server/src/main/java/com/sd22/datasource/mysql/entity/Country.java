package com.sd22.datasource.mysql.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name ="countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int countryId;

    private String name;

    //parent forward
    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<Location> locations;

    public Country() {
    }

    public Country(String name, Set<Location> locations) {
        this.countryId = countryId;
        this.name = name;
        this.locations = locations;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", name='" + name + '\'' +
                ", locations=" + locations +
                '}';
    }
}
