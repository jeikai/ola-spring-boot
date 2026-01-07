package com.example.buoi4.dto;

public class AuthResponse {
    private String token;
    private String type = "Bearer";
    private String username;
    private String email;
    private int id;

    public AuthResponse(String token, String username, String email,int id) {
        this.token = token;
        this.username = username;
        this.email = email;
        this.id = id;
    }
}
