package com.sd22.database.neo4j.entity;

import org.springframework.data.neo4j.core.schema.*;

@Node
public class User {

    @Id
    private String email;

    private String password;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
