package com.example.map.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="roles")
public class Role extends BaseEntity{
    private RoleName role;
//    private Set<User> users;

    public Role() {

    }

    @Enumerated(EnumType.STRING)
    public RoleName getRole() {
        return this.role;
    }

    public Role setRole(RoleName role) {
        this.role = role;
        return this;
    }

//    @ManyToMany(mappedBy = "roles")
//    public Set<User> getUsers() {
//        return this.users;
//    }
//
//    public Role setUsers(Set<User> users) {
//        this.users = users;
//        return this;
//    }
}
