package com.javafortesters.chap012inheritance.examples;

import com.javafortesters.domainentities.examples.User;
import com.javafortesters.domainobject.TestAppEnv;

public class EnvironmentUser extends User {

    public String getUrl(){
        return TestAppEnv.getUrl();
    }

}
