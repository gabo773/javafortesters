package com.javafortesters.chap015stringrevisited.exercises;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class StringBuilderTests {

    @Test
    public void stringBuilderCanResize(){
        StringBuilder builder = new StringBuilder(10);
        assertThat(builder.capacity(), is(10));

        builder.append("HelloWorld");
        assertThat(builder.capacity(), is(10));

        builder.delete(builder.indexOf("W"), builder.length());
        assertThat(builder.capacity(), is(10));

        builder.append("from around the World");
        assertTrue(builder.capacity() > 10);
        assertThat(builder.capacity(), is(builder.length()));
    }

    @Test
    public void stringBuilderInsertTest(){
        StringBuilder builder = new StringBuilder();

        builder.insert(0, "Hello");
        assertThat(builder.toString(), is("Hello"));

        builder.insert(builder.length(), "World");
        assertThat(builder.toString(), is("HelloWorld"));

        //add white space and punctuation
        for(int i = 1; i<builder.length(); i++){
            if(Character.isUpperCase(builder.charAt(i))){
                builder.insert(i, " ");
                i++;
            }
        }
        builder.insert(builder.length(), "!");

        assertThat(builder.toString(), is("Hello World!"));
    }
}
