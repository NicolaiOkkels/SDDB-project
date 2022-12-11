package com.sd22.datasource.neo4j.entity;

import org.springframework.data.neo4j.core.schema.*;

@Node
public class Tag {

    @Id
    @GeneratedValue
    private Long id;

    private final String name;

    public Tag(String name) {
        this.name = name;
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
