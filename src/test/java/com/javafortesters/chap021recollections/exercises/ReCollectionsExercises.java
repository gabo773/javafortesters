package com.javafortesters.chap021recollections.exercises;

import com.javafortesters.domainentities.DupeUserComparator;
import com.javafortesters.domainentities.examples.User;
import org.junit.Test;

import java.util.SortedSet;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class ReCollectionsExercises {

    @Test
    public void canFilterDuplicateUsernamesInSortedSet(){

        User bob1 = new User("bob" ,"pa55w0rd"); // 11
        User morciu = new User("Marian", "parola"); //12
        User cpop = new User("bob", "newPassword"); //15
        User bob2 = new User("CPop", "otherPassword"); //16
        User gabo = new User("gab", "password"); // 11

        SortedSet<User> userSortedList = new TreeSet<>(new DupeUserComparator());

        userSortedList.add(bob1);
        userSortedList.add(morciu);
        userSortedList.add(cpop);
        userSortedList.add(bob2);
        userSortedList.add(gabo);

        User[] users = new User[userSortedList.size()];
        userSortedList.toArray(users);

        assertThat(userSortedList.size()).isEqualTo(4);
        assertThat(users[0].getUsername()).isEqualTo("bob");
        assertThat(users[1].getUsername()).isEqualTo("gab");
        assertThat(users[2].getUsername()).isEqualTo("Marian");
        assertThat(users[3].getUsername()).isEqualTo("CPop");
    }
}
