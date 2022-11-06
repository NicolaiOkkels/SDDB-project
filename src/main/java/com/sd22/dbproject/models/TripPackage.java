package com.sd22.dbproject.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "packages")
public class TripPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageId;

    private String description;
    private double price;
    private double discount;

    @OneToMany(mappedBy = "tripPackage", cascade = CascadeType.ALL)
    private List<Trip> trips;

    //TODO - find cascade type!
    //TODO - check if mappedby relation is correct!!
    @ManyToMany(mappedBy = "tripPackages")
    @JoinTable(
            name = "package_tags",
            joinColumns = @JoinColumn(name = "packages_package_id", referencedColumnName = "package_id"),
            inverseJoinColumns = @JoinColumn(name = "tags_tag_id", referencedColumnName = "tag_id"))

    private Set<Tag> tags = new HashSet<>();

    public TripPackage() {
    }

    public TripPackage(String description, double price, double discount) {
        this.description = description;
        this.price = price;
        this.discount = discount;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public int getPackageId() {
        return packageId;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Package{" +
                "packageId=" + packageId +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
