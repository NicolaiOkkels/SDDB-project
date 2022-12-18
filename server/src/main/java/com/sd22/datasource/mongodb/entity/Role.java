package com.sd22.datasource.mongodb.entity;

import com.sd22.datasource.mongodb.entity.User;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;

@Document(collection = "roles")
public class Role {
    @Id
    private int id;
    private String name;

    private List<com.sd22.datasource.mongodb.entity.User> users;
    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }

    public List<com.sd22.datasource.mongodb.entity.User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
