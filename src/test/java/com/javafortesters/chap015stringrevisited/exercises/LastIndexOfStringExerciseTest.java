package com.javafortesters.chap015stringrevisited.exercises;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class LastIndexOfStringExerciseTest {

    @Test(expected = IllegalArgumentException.class)
    public void canNotSearchForEmptyString(){
        findAllOccurrencesLast("", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotWorkWithNullString(){
        findAllOccurrencesLast(null, "z");
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotWorkWithNullSubstring(){
        findAllOccurrencesLast("Hello", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bothArgumentsAreNull(){
        findAllOccurrencesLast(null, null);
    }

    @Test
    public void worksWithEmptyString(){
        List<Integer> results = findAllOccurrencesLast("", "z");
        assertThat(results.size(), is(0));
    }

    @Test
    public void worksWhenNoFind(){
        List<Integer> results = findAllOccurrencesLast("Hello", "z");
        assertThat(results.size(), is(0));
    }

    @Test
    public void allOccurrencesFromLastTest(){
        String s1 = "l'Hello fellal";
        String s2 = "l";

        List<Integer> results = findAllOccurrencesLast(s1, s2);

        assertThat(results.size(), is(6));

        assertThat(results.get(0), is(13));
        assertThat(results.get(1), is(11));
        assertThat(results.get(2), is(10));
        assertThat(results.get(3), is(5));
        assertThat(results.get(4), is(4));
        assertThat(results.get(5), is(0));
    }

    private List<Integer> findAllOccurrencesLast(String string, String substring) {
        List<Integer> allOccurrencesLast = new ArrayList<Integer>();

        if(string == null || substring == null){
            throw new IllegalArgumentException("Cannot search with null");
        }

        if(substring.isEmpty()){
            throw new IllegalArgumentException("Cannot search for empty string");
        }

        int currentLastIndex = string.length();
        while (currentLastIndex != -1) {
            currentLastIndex = string.lastIndexOf(substring, currentLastIndex);
            if (currentLastIndex != -1) {
                allOccurrencesLast.add(currentLastIndex);
                currentLastIndex--;
            }
        }
        return allOccurrencesLast;
    }
}
