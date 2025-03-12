package com.banking.app.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterUserRequest {
    private static final Logger log = LoggerFactory.getLogger(RegisterUserRequest.class);
    private String username;
    private String password;

    public RegisterUserRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
