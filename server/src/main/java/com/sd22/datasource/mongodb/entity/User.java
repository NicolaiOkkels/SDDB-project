package com.sd22.datasource.mongodb.entity;

import com.sd22.datasource.mysql.entity.Review;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.DBRef;

@Document(collection = "users")
public class User {
        @Id
        private String id;

        @NotBlank
        @Size(max = 20)
        private String username;

        @NotBlank
        @Size(max = 50)
        @Email
        private String email;

        @NotBlank
        @Size(max = 120)
        private String password;

        @DBRef
        private Set<Role> roles = new HashSet<>();

        private List<Review> reviews;

        public User() {
        }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<com.sd22.datasource.mongodb.entity.Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<com.sd22.datasource.mongodb.entity.Role> roles) {
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
