package com.javafortesters.chap015stringrevisited.exercises;

import com.javafortesters.domainentities.exceptions.InvalidPassword;
import com.javafortesters.domainentities.exceptions.User;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserWithValidPasswordTest {

    @Test
    public void defaultPasswordIsInvalid() {
        try{
            User user = new User();
        }catch (IllegalArgumentException expectedException){
            assertThat(expectedException.getMessage(), containsString("Default password is incorrect"));
        }
    }

    @Test
    public void passwordShorterThanSixCharacters() {
        try{
            User user = new User("user", "pass");
        } catch (InvalidPassword expectedException){
            assertThat(expectedException.getMessage(), containsString("Pass must be > 6 chars"));
        }
    }

    @Test
    public void passwordWithoutDigit() {
        try {
            User user = new User("user", "Password");
        }catch (InvalidPassword expectedException) {
            assertThat(expectedException.getMessage(), containsString("Pass must contain a digit"));
        }
    }

    @Test
    public void passwordWithoutUpper() {
        try {
            User user = new User("user", "pa55word");
        } catch (InvalidPassword expectedException){
            assertThat(expectedException.getMessage(), containsString("Pass must contain an upper case"));
        }
    }

    @Test
    public void userWithValidPassword() {
        User user = null;
        try {
            user = new User("user", "Pa55word");
        } catch (InvalidPassword e) {
            System.out.println(e.getMessage());
        }

        assertThat(user.getUsername(), is("user"));
        assertThat(user.getPassword(), is("Pa55word"));

    }

}
