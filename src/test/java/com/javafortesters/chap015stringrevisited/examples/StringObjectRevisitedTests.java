package com.javafortesters.chap015stringrevisited.examples;

import com.javafortesters.domainentities.exceptions.User;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.hamcrest.CoreMatchers.nullValue;
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
        String thisIs = "This is ";

        int i = 4;
        String s1 = thisIs.concat(Integer.toString(i));
        assertEquals("This is 4", s1);

        boolean b = true;
        String s2 = thisIs.concat(Boolean.toString(b));
        assertThat(s2, is("This is true"));

        int j = 7;
        String s3 = thisIs.concat(String.valueOf(j));
        assertThat(s3, is("This is 7"));

        boolean c = false;
        String s4 = thisIs.concat(String.valueOf(c));
        assertThat(s4, is("This is false"));

        assertThat(nullValue().toString(), is("null"));

        assertThat(Integer.valueOf("2"), is(2));
        assertThat(Boolean.valueOf("true"), is(true));

        char chArray[] = {'2', '3'};
        assertThat("23".toCharArray(), is(chArray));
    }

    @Test
    public void canConvertBytesUTF8() throws UnsupportedEncodingException {

        byte b8Array[] = "Gaboolean Analytica".getBytes("UTF8");
        for(byte b : b8Array){
            System.out.println(b);
        }
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
}
