package com.example.map.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(min = 3, max=20)
    private String firstName;

    @NotBlank
    @Size(min = 3, max=20)
    private String lastName;

    @NotBlank
    @Size(min = 5)
    private String password;

    @NotBlank
    private String age;

    @NotBlank
    @Size(max = 60)
    @Email
    private String email;

    private Set<String> role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public SignupRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SignupRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getAge() {
        return age;
    }

    public SignupRequest setAge(String age) {
        this.age = age;
        return this;
    }
}
