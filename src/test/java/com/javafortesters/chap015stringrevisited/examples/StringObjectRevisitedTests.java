package com.javafortesters.chap015stringrevisited.examples;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

public class StringObjectRevisitedTests {

    @Test
    public void stringObjectTests(){

        String aString = "12345";

        assertThat(aString.length(), is(5));
        assertEquals(aString, "12"+"34"+"5");
    }

    @Test
    public void stringConcatTests() {
        String thisIs = "This is";
        int i = 4;
        String s1 = thisIs.concat("4");

        assertEquals("This is 4", s1);

    }
}
