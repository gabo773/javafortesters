package com.javafortesters.chap014junitexplored.examples;

import com.javafortesters.domainentities.exceptions.InvalidPassword;
import com.javafortesters.domainentities.exceptions.User;
import org.junit.Test;

public class JUnitExploredExamplesTests {

    @Test
    public void thisTestWillNeverFail(){}

    @Test(expected = InvalidPassword.class)
    public void expectInvalidPasswordException() throws InvalidPassword{
        User user = new User("username", "<6");
    }
}
