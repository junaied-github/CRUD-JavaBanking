package com.bank;

public class Executive {

    public String username;
    public String password;

    public Executive(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return username;
    }
}
