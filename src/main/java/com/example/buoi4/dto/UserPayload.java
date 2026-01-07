package com.example.buoi4.dto;

public class UserPayload {
    private String email;
    private String username;
    private int id;

    public UserPayload() {
    }

    public UserPayload(String username, String email, int id) {
        this.username = username;
        this.email = email;
        this.id = id;
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
