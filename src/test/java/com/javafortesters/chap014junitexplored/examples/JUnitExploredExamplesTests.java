package com.javafortesters.chap014junitexplored.examples;

import com.javafortesters.domainentities.exceptions.InvalidPassword;
import com.javafortesters.domainentities.exceptions.User;
import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThrows;

public class JUnitExploredExamplesTests {

    @Rule
    public ExpectedException expected = ExpectedException.none();

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
    public void invalidPasswordThrown() throws InvalidPassword{
        expected.expect(InvalidPassword.class);
        expected.expectMessage(containsString("> 6 chars"));
        User user = new User("username", "<6");
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

}
