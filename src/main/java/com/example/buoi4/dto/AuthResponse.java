package com.example.buoi4.dto;

public class AuthResponse {
    private String token;
    private String type = "Bearer";
    private String username;
    private String email;
    private int id;

    public AuthResponse() {
    }

    public AuthResponse(String token, String username, String email, int id) {
        this.token = token;
        this.username = username;
        this.email = email;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
