package com.sd22.dbproject.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tagId;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "package_tags",
            joinColumns = @JoinColumn(name = "tags_tag_id"),
            inverseJoinColumns = @JoinColumn(name = "packages_package_id"))
    private List<TripPackage> tripPackages;

    @JsonBackReference
    @ManyToMany(mappedBy = "tripTags", fetch = FetchType.LAZY)
    private List<Trip> trips;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public List<TripPackage> getTripPackages() {
        return tripPackages;
    }

    public void setTripPackages(List<TripPackage> tripPackages) {
        this.tripPackages = tripPackages;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", name='" + name + '\'' +
                '}';
    }
}
