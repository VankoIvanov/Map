package com.example.map.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{
    private String title;
    private String url;
    private User author;

    public Picture() {
    }

    @Column(nullable = false)
    public String getTitle() {
        return this.title;
    }

    public Picture setTitle(String title) {
        this.title = title;
        return this;
    }

    @Column(nullable = false, columnDefinition = "TEXT")
    public String getUrl() {
        return this.url;
    }

    public Picture setUrl(String url) {
        this.url = url;
        return this;
    }

    @ManyToOne
    public User getAuthor() {
        return this.author;
    }

    public Picture setAuthor(User author) {
        this.author = author;
        return this;
    }
}
