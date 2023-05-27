package com.javafortesters.chap021recollections.examples;

import com.javafortesters.domainentities.UserComparator;
import com.javafortesters.domainentities.exceptions.InvalidPassword;
import com.javafortesters.domainentities.examples.User;
import org.junit.Test;

import java.util.*;

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

//        for(User user : users){
//            System.out.println(user.getUsername() + " - " + user.getPassword());
//        }

        assertThat(users[0].getUsername()).isEqualTo("sun");
        assertThat(users[1].getUsername()).isEqualTo("Bob");
        assertThat(users[2].getUsername()).isEqualTo("Stafford");
        assertThat(users[3].getUsername()).isEqualTo("TinyTim");
        assertThat(users[4].getUsername()).isEqualTo("Richie");
    }

    @Test
    public void createSortedMap(){
        SortedMap<String, String> map = new TreeMap<>();

        map.put("key1", "value1");
        map.put("key3", "value3");
        map.put("key2", "value2");
        map.put("key5", "value5");
        map.put("key4", "value4");

        assertThat(map.firstKey()).isEqualTo("key1");
        assertThat(map.lastKey()).isEqualTo("key5");

        SortedMap<String, String> headMap;
        headMap = map.headMap("key3");

        assertThat(headMap.size()).isEqualTo(2);
        assertThat(headMap.containsKey("key1")).isTrue();
        assertThat(headMap.containsKey("key2")).isTrue();
        assertThat(headMap.containsKey("key3")).isFalse();

        SortedMap<String, String> tailMap;
        tailMap = map.tailMap("key3");

        assertThat(tailMap.size()).isEqualTo(3);
        assertThat(tailMap.containsKey("key3")).isTrue();
        assertThat(tailMap.containsKey("key4")).isTrue();
        assertThat(tailMap.containsKey("key5")).isTrue();
        assertThat(tailMap.containsKey("key2")).isFalse();

        SortedMap<String, String> subMap;
        subMap = map.subMap("key2", "key4");

        assertThat(subMap.size()).isEqualTo(2);
        assertThat(subMap.containsKey("key2")).isTrue();
        assertThat(subMap.containsKey("key3")).isTrue();
        assertThat(subMap.containsKey("key4")).isFalse();
    }

    @Test
    public void sortedMapWithComparatorForUser(){
        User bob = new User("Bob", "pa55w0rd");    // 11
        User tiny = new User("TinyTim", "hello");  // 12
        User rich = new User("Richie", "RichieRichieRich"); // 22
        User sun = new User("sun", "tzu"); // 6
        User mrBeer = new User("Stafford", "sys"); // 11

        SortedMap<User, String> userSortedMap = new TreeMap<>(new UserComparator());

        userSortedMap.put(bob, "Bob rules");
        userSortedMap.put(tiny, "Tiny Time");
        userSortedMap.put(rich, "Rich Richie");
        userSortedMap.put(sun, "Warfare art");
        userSortedMap.put(mrBeer, "Cybernetician");

        User[] users = new User[userSortedMap.size()];
        userSortedMap.keySet().toArray(users);

//        for(User user : users){
//            System.out.println(user.getUsername() + " - " + user.getPassword());
//        }

        assertThat(users[0].getUsername()).isEqualTo(sun.getUsername());
        assertThat(users[1].getUsername()).isEqualTo(bob.getUsername());
        assertThat(users[2].getUsername()).isEqualTo(mrBeer.getUsername());
        assertThat(users[3].getUsername()).isEqualTo(tiny.getUsername());
        assertThat(users[4].getUsername()).isEqualTo(rich.getUsername());

    }
}
