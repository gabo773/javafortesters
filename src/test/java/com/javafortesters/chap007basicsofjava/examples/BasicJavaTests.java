package com.javafortesters.chap007basicsofjava.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicJavaTests {

    @Test
    public void bitwiseShiftOperatorsExplored(){
        int x = 56;

        assertEquals(x*2, x<<1);
        assertEquals(x*4, x<<2);
        assertEquals(x*8, x<<3);
        assertEquals(x*16, x<<4);
        assertEquals(x*32, x<<5);

        x = Integer.MAX_VALUE;
        assertEquals(Integer.MAX_VALUE/2, x>>1);
        assertEquals(Integer.MAX_VALUE/4, x>>2);
        assertEquals(Integer.MAX_VALUE/8, x>>3);
        assertEquals(Integer.MAX_VALUE/16, x>>4);
        assertEquals(Integer.MAX_VALUE/32, x>>5);
    }

    @Test
    public void someStringMethods(){
        String aString = "abcdefghij";

        assertEquals("bcd", aString.substring(1,4));
    }

    @Test
    public void exploreStringClass(){
        String s = "this is a string";
        s += " and more";
        s = "this is a whole different string";
        System.out.println(s);

        char a = '\u00c2';
        System.out.println(a);
    }
}
