package com.javafortesters.chap021recollections.exercises;

import com.javafortesters.domainentities.comparator.User;
import org.junit.Test;

import java.util.SortedSet;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class SortedSetExercisesComparableUserClassTest {

    @Test
    public void sortedSetWithComparableUser(){
        User bob1 = new User("Bob", "pa55word");
        User rich = new User("Ritchie", "RichRichyRich");
        User bob2 = new User("Bob", "mightyBob");
        User tiny = new User("sun", "tzu");
        User bob3 = new User("Bob", "BigMightyBob");

        SortedSet<User> usersSortedList = new TreeSet<>();

        usersSortedList.add(bob1);
        usersSortedList.add(rich);
        usersSortedList.add(bob2);
        usersSortedList.add(tiny);
        usersSortedList.add(bob3);

        User[] users = new User[usersSortedList.size()];
        usersSortedList.toArray(users);

        assertThat(usersSortedList.size()).isEqualTo(3);
        assertThat(users[0].getUsername()).isEqualTo("sun");
        assertThat(users[1].getUsername()).isEqualTo("Bob");
        assertThat(users[2].getUsername()).isEqualTo("Ritchie");

    }
}
