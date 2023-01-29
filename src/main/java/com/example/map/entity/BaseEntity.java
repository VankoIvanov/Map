package com.example.map.entity;

import jakarta.persistence.*;

@MappedSuperclass
public class BaseEntity {
    private Long id;

    public BaseEntity() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", columnDefinition = "SERIAL")
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
