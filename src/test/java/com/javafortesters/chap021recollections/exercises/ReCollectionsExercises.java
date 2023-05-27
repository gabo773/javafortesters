package com.javafortesters.chap021recollections.exercises;

import com.javafortesters.domainentities.DupeUserComparator;
import com.javafortesters.domainentities.UserComparator;
import com.javafortesters.domainentities.examples.User;
import org.junit.Test;

import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
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

    @Test
    public void createSortedSetFromSortedMapKeys(){
        SortedMap<User, String> userSortedMap = new TreeMap<>(new UserComparator());

        User bob = new User("Bob", "pa55w0rd");
        User richie = new User("Richie", "RichieRichieRich");
        User tiny = new User("Tiny", "TinyTime");
        User sun = new User("sun", "tzu");
        User mrBeer = new User("Stafford", "sys");

        userSortedMap.put(bob, "Bob the user");
        userSortedMap.put(richie, "Rich Richie");
        userSortedMap.put(tiny, "Tiny Tim");
        userSortedMap.put(sun, "Warfare art");
        userSortedMap.put(mrBeer, "Cybernetician");

        User[] users = new User[userSortedMap.size()];
        userSortedMap.keySet().toArray(users);

        for (User user : users) {
            System.out.println(user.getUsername());
            }
    }
}
