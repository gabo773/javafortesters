package com.javafortesters.chap005testwithourownclasses.domainobjects.examples;

import com.javafortesters.domainobject.TestAppEnv;
import org.junit.Test;

import org.junit.Assert;

public class TestAppEnvironmentTest {

    @Test
    public void canGetUrlStatically(){

        Assert.assertEquals("Returns hard coded url",
                "http://192.123.0.3:67",
                TestAppEnv.getUrl());

    }

    @Test
    public void canGetDomainAndPortStatically(){
        Assert.assertEquals("Just the domain",
                "192.123.0.3",
                TestAppEnv.DOMAIN);

        Assert.assertEquals("Just the port",
                "67",
                TestAppEnv.PORT);
    }
}
