package com.BootCampProject1.model;

public class AuthenticationResponse {

    String jwt;

    public String getJwt() {
        return jwt;
    }

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }
}
