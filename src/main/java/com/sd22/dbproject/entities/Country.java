package com.sd22.dbproject.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name ="countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int countryId;
    private String name;
    @OneToMany(mappedBy = "locationId", cascade = CascadeType.ALL)
    private Set<Location> locations;

    public Country(String name, Set<Location> locations) {
        this.countryId = countryId;
        this.name = name;
        this.locations = locations;
    }

}
