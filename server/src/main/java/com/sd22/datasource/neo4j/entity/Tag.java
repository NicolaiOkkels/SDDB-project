package com.sd22.datasource.neo4j.entity;

import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Node
public class Tag {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Tag(String name) {
        this.name = name;
    }

    public Tag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
