package com.javafortesters.chap015stringrevisited.exercises;

import org.junit.Test;

public class StringObjectRevisitedExercisesTests {

    @Test
    public void specialCharacterTest(){
/*
        \t - a tab character
        \b - backspace
        \n - a new line
        \r - a carriage return
        \' - a single quote
        \" - a double quote
        \\ - a backslash
    */
        System.out.println("This is a tab \t spacing");
        System.out.println("This is a backspace \b with special character encoding");
        System.out.println("every \nword \nis \non \na \nnew \nline");
        System.out.println("This is a carriage return \r return");
        System.out.println("It's \'ok\' in quotes.");
        System.out.println("It's \"ok\" in quotes.");
        System.out.println("This is a \\backslash at American values.");
    }
}
