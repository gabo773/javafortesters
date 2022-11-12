package com.javafortesters.chap009arraysandforloops.examples;

import com.javafortesters.domainentities.examples.User;
import org.junit.Test;

import java.util.Arrays;

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
        assertEquals("gabo", users[0].getUsername());
        assertEquals("morciu", users[1].getUsername());
        assertEquals("c_sharp", users[2].getUsername());

       for (User aUser : users){
            System.out.println(aUser.getUsername());
        }
    }

    @Test
    public void oneHundredUsers(){
        User users[] = new User[100];

        for (int i=0; i<users.length;i++){
            int userID = i+1;
            String username = "user" + userID;
            String password = "password" + userID;
            users[i] = new User(username, password);
        }

        assertEquals("users array contains 100 users"
                ,100
                , users.length);

        int userID = 1;
        for(User aUser : users){
            assertEquals("user" + userID
                    , aUser.getUsername() );
            assertEquals("password"+userID
                    , aUser.getPassword());
            userID++;
            assertNotNull("null user in users[] array", aUser);
        }
    }

    @Test
    public void sortWorkdays(){
        String workdays[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        Arrays.sort(workdays);
        assertEquals("Friday", workdays[0]);
        assertEquals("Monday", workdays[1]);
        assertEquals("Thursday", workdays[2]);
        assertEquals("Tuesday", workdays[3]);
        assertEquals("Wednesday", workdays[4]);
    }

    @Test
    public void sortDifferentCaseWorkdays(){
        String workdays[] = {"monday", "Tuesday", "Wednesday", "thursday", "Friday"};
        Arrays.sort(workdays);

        int dayIndex = 0;
        String sameCaseWorkdays[] = new String[5];
        for (String day : workdays){
            sameCaseWorkdays[dayIndex] = capitalizeSingleWords(day);
            dayIndex++;
        }

        for(String day : sameCaseWorkdays){
            System.out.println(day);
        }

        Arrays.sort(sameCaseWorkdays);
        assertEquals("Friday", sameCaseWorkdays[0]);
        assertEquals("Monday", sameCaseWorkdays[1]);
        assertEquals("Thursday", sameCaseWorkdays[2]);
        assertEquals("Tuesday", sameCaseWorkdays[3]);
        assertEquals("Wednesday", sameCaseWorkdays[4]);
    }

    private String capitalizeSingleWords(String word) {
        word = word.toLowerCase();

        String firstLetter = String.valueOf(word.charAt(0)).toUpperCase();
        String restOfWord = word.substring(1);

        return firstLetter+restOfWord;
    }

    public void print2DIntArray(int multi[][]){
        for(int outer[] : multi){
            if(outer == null){
                System.out.print("null");
            }else{
                for(int inner : outer){
                    System.out.print(inner + ",");
                }
            }
            System.out.println("");
        }
    }

    @Test
    public void triangleOfIntArray(){

        int multi[][] = new int[16][];

        for(int i=0; i<multi.length; i++){
            multi[i] = new int[i+1];
            for(int j=0; j<multi[i].length; j++) {
                multi[i][j] = j;
            }
        }

        print2DIntArray(multi);
    }
}
