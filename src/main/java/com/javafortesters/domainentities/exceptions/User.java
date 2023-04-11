package com.javafortesters.domainentities.exceptions;

public class User {
    
    String username;
    String password;
    
    public User(){
        this ("username", "password", false);
    }

    private User(String username, String password, boolean b){
        this.username = username;
        try{setPassword(password);
        }catch (InvalidPassword e){
            throw new IllegalArgumentException("Default password is incorrect", e);
        }
    }
    
    public User(String username, String password) throws InvalidPassword{
        this.username = username;
        setPassword(password);
    }

    public void setPassword(String password) throws InvalidPassword{
        String mustIncludeDigit = ".*[0123456789]+.*";
        String mustIncludeUpperCase = ".*[A-Z]+.*";

        if (password.length()<6){
            throw new InvalidPassword("Pass must be > 6 chars");
        }
        if(!password.matches(mustIncludeDigit)){
            throw new InvalidPassword("Pass must contain a digit");
        }
        if(!password.matches(mustIncludeUpperCase)){
            throw new InvalidPassword("Pass must contain an upper case");
        }

        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}
