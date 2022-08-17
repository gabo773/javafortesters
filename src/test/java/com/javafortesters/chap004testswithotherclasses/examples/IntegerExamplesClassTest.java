package com.javafortesters.chap004testswithotherclasses.examples;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.awt.*;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class IntegerExamplesClassTest {

    public IntegerExamplesClassTest(){}

    @Test
    public void integerExploration(){
        Integer four = new Integer(4);
        Integer five = new Integer("5");
        Integer six = 6;

        int myNum[] = {1, 2, 3, 45, 5, 2, 54, 65, 5};
        int myNumMax = Arrays.stream(myNum).max().getAsInt();

        assertEquals("intValue returns int 5", 5, five.intValue());
        assertEquals("intValue returns int 4", 4, four.intValue());
        assertEquals("intValue returns int 6", 6, (int) six);
        assertEquals("intValue returns int 65", 65, myNumMax);
    }

    @Test
    public void toHexString(){
        String a = Integer.toHexString(11);
        String b = Integer.toHexString(10);
        String c = Integer.toHexString(3);
        String d = Integer.toHexString(21);

        assertEquals("toHexString of 11 is b", "b", a);
        assertEquals("toHexString of 10 is a", "a", b);
        assertEquals("toHexString of 3 is 3", "3", c);
        assertEquals("toHexString of 21 is 15", "15", d);
    }

    @Test
    public void minAndMaxIntegerConstants(){
        Integer max = Integer.MAX_VALUE;
        Integer min = Integer.MIN_VALUE;

        assertEquals("max integer value is 2147483647", 2147483647, max.intValue());
        assertEquals("min integer is -2147483648", "-2147483648", min.toString());
    }

    @Test
    public void exploreRotateInteger(){
        Integer newInt = 641;
        newInt = newInt.reverse(2147483647);

        System.out.println(newInt);
    }
}
