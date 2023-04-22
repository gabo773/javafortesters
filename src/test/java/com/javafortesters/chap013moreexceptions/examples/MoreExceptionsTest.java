package com.javafortesters.chap013moreexceptions.examples;

import com.javafortesters.domainentities.exceptions.InvalidPassword;
import com.javafortesters.domainentities.exceptions.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoreExceptionsTest {

    @Test
    public void canCreateDefaultUserWithoutHandlingException(){
        try{
        User aUser = new User("username", "Pa55word");
        assertEquals("username", aUser.getUsername());
        assertEquals("Pa55word", aUser.getPassword());
        }catch (InvalidPassword e){
            System.out.println(e.getStackTrace());
        }
    }

    @Test
    public void haveToCatchIllegalPasswordForParamConstructor() {
        User aUser = null;
        try {
            aUser = new User("me", "wrong");
            fail("An exception should have been thrown");
        } catch (InvalidPassword e) {
            assertTrue("The exception was thrown", true);
        }
        try {
            assertEquals("wrong", aUser.getPassword());
        }catch(NullPointerException e){
            System.out.println("InvalidPassword exception thrown. User is null");
        }
    }
}
