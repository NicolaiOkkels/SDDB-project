package com.sd22.dbproject.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tagId;

    private String name;

    public Tag(String name) {
        this.name = name;
    }
}
