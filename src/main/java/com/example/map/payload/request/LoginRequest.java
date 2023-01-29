package com.example.map.payload.request;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public String getUsername() {
        return this.username;
    }

    public LoginRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return this.password;
    }

    public LoginRequest setPassword(String password) {
        this.password = password;
        return this;
    }
}
