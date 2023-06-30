package com.selfproject.policedepartment.dto.requests;

public class AuthRequest {

    private String token;

    public AuthRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
