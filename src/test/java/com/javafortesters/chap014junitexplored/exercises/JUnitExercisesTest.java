package com.javafortesters.chap014junitexplored.exercises;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class JUnitExercisesTest {

    @Test
    public void junitAssertions(){
        assertEquals(49, 7*7);
        assertEquals("7*7=49", 49, 7*7);

        assertFalse(false);
        assertFalse("This is not true:", false);

        assertTrue(true);
        assertTrue("This is true", true);

        int oneToTen[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int tenToOne[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Arrays.sort(tenToOne);
        assertArrayEquals(oneToTen, tenToOne);

        assertNotNull("An empty string is not null", "");
        assertNotNull("");

        assertNotSame("An empty string is not null", null, "");
        assertNotSame(null, "");

        assertNull("Only null is null", null);
        assertNull(null);

        assertSame("Only null is null", null, null);
        assertSame(null, null);
    }
}
