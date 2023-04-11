package com.javafortesters.chap015stringrevisited.exercises;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

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
    @Test
    public void stringConstructors(){
        String s1 = new String();
        assertThat(s1.isEmpty(), is(true));

        char chArray[] = {'2', '3', '4', ' ', 'a', '-', 'Z'};
        String s2 = new String(chArray);
        assertThat(s2, is("234 a-Z"));

        byte b8Array[];
        try {
            b8Array = "Gaboolean@Analytica".getBytes("UTF8");
        } catch (UnsupportedEncodingException encodingException){
            System.out.println(encodingException.getMessage());
            return;//exit the method early if an exception is thrown
        }

        if(b8Array == null){return;//exit the method early if b8Array is null
        }

        String s3 = new String(b8Array);
        assertThat(s3, is("Gaboolean@Analytica"));
    }

    @Test
    public void stringRegionMatchesMethodExercise(){
        String s1 = "Hello fella";
        String s2 = "young lady";
        assertThat(s1.regionMatches(true, 9, s2, 6, 2),
                is(true));
    }

    @Test
    public void replaceStringExamples(){
        String hello = "Hello fella fella fella";

        assertThat(hello.replace("fella", "world"),
                        is("Hello world world world"));
        assertThat(hello.replaceFirst("fella", "world"),
                    is("Hello world fella fella"));
        assertThat("1, 2, 3".replaceAll("[0-9]", "digit"),
                    is("digit, digit, digit"));
        assertThat("1, 2, 3".replaceFirst("[0-9]", "digit"),
                    is("digit, 2, 3"));
    }



}
