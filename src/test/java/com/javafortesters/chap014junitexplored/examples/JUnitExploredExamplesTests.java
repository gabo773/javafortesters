package com.javafortesters.chap014junitexplored.examples;

import com.javafortesters.domainentities.exceptions.InvalidPassword;
import com.javafortesters.domainentities.exceptions.User;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThrows;

public class JUnitExploredExamplesTests {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @BeforeClass
    public static void runOncePerClassBeforeAnyTests(){
        System.out.println("@BeforeClass method");
    }

    @Before
    public void runBeforeEveryTestMethod(){
        System.out.println("@Before each method");
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

}
