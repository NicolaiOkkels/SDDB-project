package com.sd22.database.neo4j.entity;

import org.springframework.data.neo4j.core.schema.*;

@Node
public class Tag {

    @Id
    private final String name;

    public Tag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
