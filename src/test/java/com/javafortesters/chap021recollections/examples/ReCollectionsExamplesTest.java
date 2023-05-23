package com.javafortesters.chap021recollections.examples;

import com.javafortesters.domainentities.UserComparator;
import com.javafortesters.domainentities.exceptions.InvalidPassword;
import com.javafortesters.domainentities.examples.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class ReCollectionsExamplesTest {

    @Test
    public void sortedSetCanMaintainOrder(){

        SortedSet<String> alphaset = new <String>TreeSet();

        alphaset.add("c");
        assertThat(alphaset.first()).isEqualTo("c");
        assertThat(alphaset.last()).isEqualTo("c");

        alphaset.add("a");
        assertThat(alphaset.first()).isEqualTo("a");
        assertThat(alphaset.last()).isEqualTo("c");

        alphaset.add("d");
        assertThat(alphaset.first()).isEqualTo("a");
        assertThat(alphaset.last()).isEqualTo("d");

        alphaset.add("b");
        assertThat(alphaset.first()).isEqualTo("a");
        assertThat(alphaset.last()).isEqualTo("d");

        alphaset.add("a");
        assertThat(alphaset.first()).isEqualTo("a");
        assertThat(alphaset.last()).isEqualTo("d");

        assertThat(alphaset.size()).isEqualTo(4);

        String[] alphas = new String[alphaset.size()];
        alphaset.toArray(alphas);

        assertThat(alphas[0]).isEqualTo("a");
        assertThat(alphas[1]).isEqualTo("b");
        assertThat(alphas[2]).isEqualTo("c");
        assertThat(alphas[3]).isEqualTo("d");
    }

    @Test
    public void sortedSetWithComparatorForUser() throws InvalidPassword {
        User bob = new User("Bob", "pa55w0rd");   // 11
        User tiny = new User("TinyTim", "hello"); // 12
        User rich = new User("Richie", "RichieRichieRich"); // 22
        User sun = new User("sun", "tzu"); // 6
        User mrBeer = new User("Stafford", "sys"); // 11

        SortedSet<User> userSortedList = new TreeSet<User>(new UserComparator());

        userSortedList.add(bob);
        userSortedList.add(tiny);
        userSortedList.add(rich);
        userSortedList.add(sun);
        userSortedList.add(mrBeer);

        User[] users = new User[userSortedList.size()];
        userSortedList.toArray(users);

        assertThat(users[0].getUsername()).isEqualTo("sun");
        assertThat(users[1].getUsername()).isEqualTo("Bob");
        assertThat(users[2].getUsername()).isEqualTo("Stafford");
        assertThat(users[3].getUsername()).isEqualTo("TinyTim");
        assertThat(users[4].getUsername()).isEqualTo("Richie");
    }
}
