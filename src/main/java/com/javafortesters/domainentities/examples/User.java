package com.javafortesters.domainentities.examples;

public class User {
    private String username;
    private String password;

    public User(){
        this("username", "password");
    }

    public User(String username, String password){
        this.username = username;
        setPassword(password);
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPermission() {
        return "Normal";
    }
}
