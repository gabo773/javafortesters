package com.javafortesters.chap012inheritance.examples;

import com.javafortesters.domainentities.examples.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InheritanceTest {

    @Test
    public void emptyUserExampleTest(){
        EmptyUser enu = new EmptyUser();
        assertEquals("emptyuser", enu.getUsername());
        assertEquals("password", enu.getPassword());
        assertEquals("Normal", enu.getPermission());
    }

    @Test
    public void envUserExampleTest(){
        EnvironmentUser env = new EnvironmentUser();
        String url = env.getUrl();
        assertEquals("http://192.123.0.3:67", url);
    }

    @Test
    public void aUserHasNormalPermission(){
        User aUser = new User();
        assertEquals("Normal", aUser.getPermission());
    }

    @Test
    public void adminUserDefaultConstructor(){
        AdminUser adminUser = new AdminUser();
        assertEquals("adminuser", adminUser.getUsername());
        assertEquals("password", adminUser.getPassword());
        assertEquals("Elevated", adminUser.getPermission());
    }

    @Test
    public void adminUserHasElevatedPermission(){
        AdminUser adminUser = new AdminUser("admin", "Pa55w0rd");
        assertEquals("admin", adminUser.getUsername());
        assertEquals("Pa55w0rd", adminUser.getPassword());
        assertEquals("Elevated", adminUser.getPermission());
    }

    @Test
    public void readOnlyUserDefaultConstructor(){
        ReadOnlyUser readOnlyUser = new ReadOnlyUser();
        assertEquals("readonlyuser", readOnlyUser.getUsername());
        assertEquals("password", readOnlyUser.getPassword());
        assertEquals("Read-Only", readOnlyUser.getPermission());
    }

    @Test
    public void readOnlyUserHasReadOnlyPermission(){
        ReadOnlyUser readOnlyUser = new ReadOnlyUser("user", "Pa55w0rd");
        assertEquals("user", readOnlyUser.getUsername());
        assertEquals("Pa55w0rd", readOnlyUser.getPassword());
        assertEquals("Read-Only", readOnlyUser.getPermission());
    }
}
