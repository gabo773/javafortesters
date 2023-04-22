package com.javafortesters.chap014junitexplored.exercises;

import com.javafortesters.domainentities.exceptions.InvalidPassword;
import com.javafortesters.domainentities.exceptions.User;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
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

    @Test
    public void assertionsWithMatchers(){
        assertThat(7*7, is(49));
        assertThat("7 * 7 = 49", 7*7, is(49));

        assertThat(false, is(false));
        assertThat("false is false", false, equalTo(false));

        assertThat("true is true", true, equalTo(true));
        assertThat(true, is(true));

        int oneToTen[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int tenToOne[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Arrays.sort(tenToOne);
        assertThat(oneToTen, equalTo(tenToOne));

        assertThat("An empty string is not null", "", is(not(nullValue())));
        assertThat("", is(notNullValue()));
        assertThat("", not(nullValue()));

        assertThat("An empty string is not null", "", not(nullValue()));

        assertThat("Only null is null", null, is(nullValue()));
        assertThat(null, nullValue());

    }

    @Test
    public void hamcrestMatchersTests() throws InvalidPassword {
        assertThat("An empty string is not null", "", is(not(equalTo(nullValue()))));
        assertThat("An empty string is not null", null, is(nullValue()));

        User user = new User("username", "passW0rd");

        assertThat(user.getPassword(), startsWith("pass"));
        assertThat(user.getUsername(), containsString("user"));
        assertThat(user.getPassword(), endsWith("W0rd"));
    }

    @Ignore
    @Test
    public void incompleteTest(){
        fail("Not yet implemented");
    }
}
