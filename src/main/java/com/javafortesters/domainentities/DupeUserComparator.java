package com.javafortesters.domainentities;

import com.javafortesters.domainentities.examples.User;

import java.util.Comparator;

public class DupeUserComparator implements Comparator {

    @Override
    public int compare(Object oUser1, Object oUser2){

        User user1 = (User)oUser1;
        User user2 = (User)oUser2;

        if(user1.getUsername().equals(user2.getUsername())){
            return 0;
        }

        int user1Comparator = user1.getUsername().length() +
                                user1.getPassword().length();

        int user2Comparator = user2.getUsername().length() +
                                user2.getPassword().length();


        int val = user1Comparator - user2Comparator;

        if(val==0){
            val = user1.getUsername().compareTo(user2.getUsername());
        }

        System.out.println("Compare " + user1.getUsername() +
                " with " + user2.getUsername() + " = " + val);

        return val;
    }
}
