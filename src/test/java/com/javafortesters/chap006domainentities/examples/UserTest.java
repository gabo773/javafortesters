package com.javafortesters.chap006domainentities.examples;

import com.javafortesters.domainentities.examples.User;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class UserTest {

    @Test
    public void canCreateNewUser(){
        User user = new User();
    }

    @Test
    public void userHasDefaultUsernameAndPassword(){

        User user = new User();

        assertEquals("expected default username",
                "username",
                user.getUsername());

        assertEquals("expected default password",
                "password",
                user.getPassword());
    }

/*  Test for public fields in User.java
    @Test
    public void canAccessPublicFieldsInUser(){

        User auser = new User();
        auser.username = "bob";
        auser.password = "pa55w0rd";

        assertEquals("user changed to bob",
                "bob",
                auser.username);
        assertEquals("password changed to pa55w0rd",
                "pa55w0rd",
                auser.password);
    }*/

    @Test
    public void canConstructWithUsernamePassword(){

        User user = new User("admin", "pa55w0rd");

        assertEquals("given username expected",
                "admin",
                user.getUsername());
        assertEquals("given password expected",
                "pa55w0rd",
                user.getPassword());
    }

    @Test
    public void canSetPasswordAfterConstructed(){

        User user = new User("bob", "password");

        user.setPassword("paZZw0rd6");

        assertEquals("password changed through setter",
                "paZZw0rd6",
                user.getPassword());
    }
}
;