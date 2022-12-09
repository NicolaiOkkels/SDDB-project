package com.sd22.dbproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name ="locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationId;
    private String name;

    public Location(int locationId, String name, Country country) {
        this.locationId = locationId;
        this.name = name;
    }


}
