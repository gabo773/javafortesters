package com.javafortesters.chap015stringrevisited.exercises;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class IndexOfStringExerciseTest {

    private List findAllOccurrences(String string, String substring){

        List<Integer> allOccurrences = new ArrayList<Integer>();

        if(string == null || substring == null){
            throw new IllegalArgumentException("Can't use search with null values");
        }

        if(substring.isEmpty()){
            throw new IllegalArgumentException("Can't search for empty string");
        }

        int currentIndex = 0;
        while(currentIndex != -1) {
            currentIndex = string.indexOf(substring, currentIndex);
            if(currentIndex != -1 ){
                allOccurrences.add(currentIndex);
                currentIndex++;
            }
        }
        return allOccurrences;
    }

    @Test
    public void worksWhenStringIsEmpty(){
        List<Integer> results = findAllOccurrences("", "z");

        assertThat(results.size(), is(0));
    }

    @Test
    public void worksWhenNoFind(){
        List<Integer> results = findAllOccurrences("Hello", "z");

        assertThat(results.size(), is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotSearchForEmptyString() {
        List<Integer> results = findAllOccurrences("Hello", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotSearchInNull(){
        List<Integer> results = findAllOccurrences(null, "z");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotSearchForNull(){
        List<Integer> results = findAllOccurrences("Hello", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bothArgumentsAreNull(){
        List<Integer> results = findAllOccurrences(null, null);
    }

    @Test
    public void findAllOccurrencesTests(){
        String s1 = "hello fella";
        String s2 = "l";

        List<Integer> results = findAllOccurrences(s1, s2);

        assertThat(results.size(), is(4));

        assertThat(results.get(0), is(2));
        assertThat(results.get(1), is(3));
        assertThat(results.get(2), is(8));
        assertThat(results.get(3), is(9));
    }
}
