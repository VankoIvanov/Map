package com.example.map.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EntityI {

    private Long id;

    @Id
    public Long getId() {
        return id;
    }

    public EntityI setId(Long id) {
        this.id = id;
        return this;
    }
}
