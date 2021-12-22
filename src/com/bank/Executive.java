package com.bank;

public class Executive {

    private String username;
    private String password;

    public Executive(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
