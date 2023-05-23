package com.javafortesters.domainentities.comparator;

public class User implements Comparable {

    private String username;
    private String password;

    public User(){
        this("username", "password");
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public int compareTo(Object oUser2){
        User user2 = (User)oUser2;

        if(this.getUsername().equals(user2.getUsername())){
            return 0;
        }

        int user1Comparator = this.getUsername().length() +
                                this.getPassword().length();

        int user2Comparator = user2.getUsername().length() +
                                user2.getPassword().length();

        int val = user1Comparator - user2Comparator;

        if(val==0){
            val = this.getUsername().compareTo(user2.getUsername());
        }

        return val;
    }
}
