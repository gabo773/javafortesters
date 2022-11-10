package com.javafortesters.chap012inheritance.examples;

import com.javafortesters.domainentities.User;

public class ReadOnlyUser extends User {

    public ReadOnlyUser(){
        this("readonlyuser", "password");
    }

    public ReadOnlyUser(String username, String password){
        super(username, password);
    }
    @Override
    public String getPermission(){
        return "Read-Only";
    }
}
