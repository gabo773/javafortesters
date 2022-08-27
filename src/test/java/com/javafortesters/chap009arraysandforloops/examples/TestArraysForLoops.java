package com.javafortesters.chap009arraysandforloops.examples;

import com.javafortesters.domainentities.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestArraysForLoops {

    @Test
    public void exploreArrays(){
        int integers[] = {0,1,2,3,4,5,6,7,8,9};

        for( int integer : integers){
            System.out.println(integer);
        }
    }

    @Test
    public void createArrayOfUsers(){
        User users[] = new User[3];
        users[0] = new User("gabo", "password");
        users[1] = new User("morciu", "parola");
        users[2] = new User("c_sharp", "pa55w0rd");

        assertEquals(3, users.length);

       for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void oneHundredUsers(){
        User users[] = new User[100];

        int usernameindex = 1;
        int passwordindex = 1;
        for (int i = 0; i<users.length; i++){
            String username = "user" + usernameindex;
            String password = "password" + passwordindex;
            users[i] = new User(username, password);
            usernameindex++;
            passwordindex++;
        }

        assertEquals("users array contains 100 users"
                ,100
                , users.length);

        for(User user : users){
            assertNotNull("null user in users array", user);
        }

    }

}
