package com.javafortesters.domainentities;

public class User {
    private String username;
    private String password;

    public User(){
        username = "username";
        password = "password";
    }

    public User(String username, String password) {
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
