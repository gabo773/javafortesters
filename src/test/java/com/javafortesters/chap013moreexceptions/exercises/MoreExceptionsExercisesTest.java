package com.javafortesters.chap013moreexceptions.exercises;

import com.javafortesters.domainentities.exceptions.InvalidPassword;
import com.javafortesters.domainentities.exceptions.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoreExceptionsExercisesTest {

    @Test
    public void invalidPasswordThrownOnSetPassword(){
        User aUser = new User();
        try{
        aUser.setPassword("wrong");
        fail("An exception should have been thrown");
        }catch (InvalidPassword e){
            assertTrue(e.getMessage().startsWith("Pass must be > 6 chars"));
        }
    }

    @Test(expected = InvalidPassword.class)
    public void exceptionThrownInConstructor() throws InvalidPassword{
        User aUser = new User("user", "p");
    }

    @Test
    public void exceptionIsNotThrownOnDefaultConstructor(){
        User aUser = new User();

        assertEquals("username", aUser.getUsername());
        assertEquals("password", aUser.getPassword());
    }

    @Test
    public void testExceptionMessage(){
        User aUser;

        try{
            aUser = new User("user", "p");
            fail("An exception should have been thrown");
        }catch (InvalidPassword e){
            assertEquals("Pass must be > 6 chars", e.getMessage());
        }
    }
}
