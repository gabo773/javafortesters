package com.javafortesters.chap003myfirsttest.examples;


import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.model.TestTimedOutException;

import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertEquals;

public class MyFirstTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1);

    @Ignore("Testing timeout. Will always fail.")
    @Test//(timeout expected for infinite loop)
    public void infinity() throws Exception{
        while(true);
    }

    @Test
    public void canAddTwoAndTwo(){
        int answer = 2+2;
        assertEquals("2+2=4", 4, answer);
    }

    @Test
    public void canSubtractTwoAndTwo(){
        int answer = 2-2;
        assertEquals("2-2=0", 0, answer);
    }

    @Test
    public void canDivideFourByTwo(){
        int answer = 4/2;
        assertEquals("4 / 2 = 2", 2, answer);
    }

    @Test
    public void canMultiplyTwoByTwo(){
        int answer = 2*2;
        assertEquals("2 * 2 = 4", 4, answer);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfBounds(){
        new ArrayList<Object>().get(1);
    }

}
