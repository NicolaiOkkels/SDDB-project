package com.sd22.dbproject.graph.models;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Tag {

    @Id
    private String name;

}
