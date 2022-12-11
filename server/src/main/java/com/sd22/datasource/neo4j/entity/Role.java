package com.sd22.datasource.neo4j.entity;

import org.springframework.data.neo4j.core.schema.*;

@Node
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    private final String name;

    public Role(String name) {
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
