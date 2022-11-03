package com.javafortesters.chap011exceptions.examples;

import com.javafortesters.domainentities.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExceptionExamplesTest {

    @Test(expected = NullPointerException.class)
    public void throwNullPointerException() {

        Integer age = null;
        String ageAsString = age.toString();
    }

    @Test
    public void tryAndCatch(){

        Integer age = null;
        String ageAsString;

        try {
            ageAsString = age.toString();
        }catch(NullPointerException e) {

            age = 18;
            ageAsString = age.toString();
        }catch(IllegalArgumentException e){
            System.out.println("Illegal argument" +
                    e.getMessage());
        }

        String yourAge = "You are " + age.toString() + " years old.";

        assertEquals("You are 18 years old.", yourAge);
    }

    @Test
    public void illegalArgumentException(){

        try {
            User newUser = new User("gabo", "parol");
        }catch(IllegalArgumentException e){
            System.out.println("Illegal Argument " + e.getMessage());
            System.out.println(e.getStackTrace());
            e.printStackTrace();
        }
    }

    @Test
    public void tryCatchFinallyANullPointerException(){

        Integer age = null;
        String ageAsString;
        String yourAge;

        try{
            ageAsString = age.toString();
        }catch(NullPointerException e){
            age = 18;
            ageAsString = age.toString();
        }finally {
            yourAge = "You are " + age.toString() + " years old.";
        }

        assertEquals("You are 18 years old.", yourAge);
    }

    @Test //(expected = IllegalArgumentException.class)
    public void tryCatchFinallyExample(){
        Integer age=null;
        try{
            System.out.println("1. generate a null pointer exception");
            System.out.println(age.toString());
        }catch(NullPointerException e){
            System.out.println("2. handle null pointer exception");
            throw new IllegalArgumentException("Null pointer became illegal", e);
        }finally{
            System.out.println("3. run code in finally section");
        }
    }
}
