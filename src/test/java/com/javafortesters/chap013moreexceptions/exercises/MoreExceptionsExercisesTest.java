package com.javafortesters.chap013moreexceptions.exercises;

import com.javafortesters.domainentities.exceptions.InvalidPassword;
import com.javafortesters.domainentities.exceptions.User;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import static org.junit.Assert.*;

public class MoreExceptionsExercisesTest {

    @Test
    public void invalidPasswordThrownOnSetPassword(){
        User aUser = null;
        try{
        aUser = new User("username", "Pa55word");
        } catch (InvalidPassword e){
            System.out.println(e.getStackTrace());
        }

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
        try{
        User aUser = new User("username", "Pa55word");

        assertEquals("username", aUser.getUsername());
        assertEquals("Pa55word", aUser.getPassword());
        }catch (InvalidPassword e) {
            System.out.println(e.getStackTrace());
        }

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

    @Test
    public void cat() {
        File file = new File("pathname");
        RandomAccessFile input = null;
        String line = null;

        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        }catch(FileNotFoundException e){
            System.err.format("File %s not found.%n", file);
            }
        catch(IOException e){
            System.err.println(e.toString());
        } finally {
            if (input != null) {
                try {
                    input.close();
                }catch (IOException e){
                    System.err.println(e.toString());
                }
            }
        }
    }
}
