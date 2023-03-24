package com.javafortesters.chap014junitexplored.examples;

import com.javafortesters.domainentities.exceptions.InvalidPassword;
import com.javafortesters.domainentities.exceptions.User;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThrows;

public class JUnitExploredExamplesTests {

    @BeforeClass
    public static void runOncePerClassBeforeAnyTests(){
        System.out.println("@BeforeClass method");
    }

    @AfterClass
    public static void runOncePerClassAfterAllTests(){
        System.out.println("@AfterClass method");
    }

    @Before
    public void runBeforeEveryTestMethod(){
        System.out.println("@Before each method");
    }

    @After
    public void runAfterEveryTestMethod(){
        System.out.println("@After each method");
    }

    @Test
    public void thisTestWillNeverFail(){}

    @Test(expected = InvalidPassword.class)
    public void expectInvalidPasswordException() throws InvalidPassword{
        User user = new User("username", "<6");
    }

    @Test
    public void invalidPasswordThrown() {

        try{
            User user = new User("username", "<6");
        } catch (InvalidPassword anInvalidPassword) {
            assertThat(anInvalidPassword.getMessage(), containsString("> 6 chars"));
        }
    }

    @Ignore("Testing the @Ignore annotation")
    @Test
    public void thisTestIsIgnored(){
        System.out.println("This test is ignored");
    }

    @Test
    public void junitAssertionsWithMatchers(){
        assertThat(3+3, is(6));
    }

    @Test
    public void testExceptionMessage() {
        ArrayList list = new ArrayList<>();

        try{
            list.get(0);
        }catch (IndexOutOfBoundsException anExpectedException) {
            assertThat(anExpectedException.getMessage(), containsString("out of bounds"));
            System.out.println(anExpectedException.getMessage());
        }
    }

}
