package com.sd22.datasource.neo4j.entity;

import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Node
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String password;

    @Relationship(type = "ASSIGNED", direction = Relationship.Direction.OUTGOING)
    private List<Role> roles;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
