package com.javafortesters.chap012inheritance.examples;

import com.javafortesters.domainentities.User;

public class EmptyUser extends User {

    public EmptyUser(){
        this("emptyuser", "password");
    }

    public EmptyUser(String username, String password){
        super(username, password);
    }
}
