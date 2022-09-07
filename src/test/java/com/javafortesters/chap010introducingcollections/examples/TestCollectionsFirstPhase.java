package com.javafortesters.chap010introducingcollections.examples;

import com.javafortesters.domainentities.User;
import com.javafortesters.domainobject.DeckOfCards;
import org.junit.Test;

import java.util.*;

import static com.javafortesters.domainobject.DeckOfCards.dealHand;
import static org.junit.Assert.*;

public class TestCollectionsFirstPhase {

    @Test
    public void whileLoopForLoop(){

        String[] workdays = {"Monday", "Tuesday"
                ,"Wednesday", "Thursday", "Friday"
                };

        List<String> someDays = Arrays.asList(workdays);
        List<String> weekendDays = new ArrayList<String>();
        weekendDays.add("Saturday");
        weekendDays.add("Sunday");
        List<String> days = new ArrayList<String>(someDays);
        days.addAll(weekendDays);

//        days.add("Sunday");
//        days.add("Monday");
//        days.add("Tuesday");
//        days.add("Wednesday");
//        days.add("Thursday");
//        days.add("Friday");
//        days.add("Saturday");
        days.add("Anotherday");

        int i = 0;
        for(;i< days.size();){
            System.out.println(days.get(i));
            i++;
        }
    }

    @Test
    public void createManipulateCollectionOfUsers(){

        Collection<User> users = new ArrayList<>();

        assertEquals(0, users.size());
        assertTrue(users.isEmpty());

        User aUser = new User("gabo", "password");
        User secondUser = new User("morciu", "pa55w0rd");

        users.add(aUser);
        users.add(secondUser);

        assertEquals(2, users.size());
        assertFalse(users.isEmpty());
//        assertEquals("gabo", users.get(0).getUsername());
//        assertEquals("morciu", users.get(1).getUsername());

        Collection<User> newUsers = new ArrayList<>();

        assertEquals(0, newUsers.size());
        assertTrue(newUsers.isEmpty());

        User thirdUser = new User("c_sharp", "par0la");
        User fourthUser = new User("nika", "P4r0la");

        newUsers.add(thirdUser);
        newUsers.add(fourthUser);

        assertEquals(2, newUsers.size());
        assertFalse(newUsers.isEmpty());
//        assertEquals("c_sharp", newUsers.get(0).getUsername());
//        assertEquals("nika", newUsers.get(1).getUsername());

        users.addAll(newUsers);

//        assertTrue(users.contains(newUsers.get(0)));
//        assertTrue(users.contains(newUsers.get(1)));
        assertTrue(users.containsAll(newUsers));
        assertEquals(4, users.size());

        newUsers.removeAll(users);

        assertTrue(newUsers.isEmpty());

        users.clear();
        assertTrue(users.isEmpty());
    }

    @Test
    public void getAnElementAtAnIndex(){
        List<String> days = new ArrayList<>();

        days.add("Monday");
        days.add("Tuesday");
        days.add("Thursday");

        assertEquals("Thursday", days.subList(2,days.size()).get(0));

        days.add(2, "Wednesday");

        assertEquals("Wednesday", days.subList(2,days.indexOf(days.get(2))+1).get(0));
    }

    @Test
    public void createShuffleList(){
        List<Integer> aList = new ArrayList<>();

        for(int i =0; i<10; i++){
            aList.add(i);
        }

        swap(aList, 2, 3);

        assertEquals(3, aList.get(2).intValue());
        assertEquals(2, aList.get(3).intValue());

        shuffle(aList, new Random());

        Collections.sort(aList);

        assertEquals(3, aList.get(3).intValue());
        assertEquals(2, aList.get(2).intValue());

        Collections.fill(aList, 0);

        assertEquals(0, aList.get(0).intValue());
        assertEquals(0, aList.get(3).intValue());
        assertEquals(0, aList.get(9).intValue());
    }

    private static <E> void swap (List<E> a, int i, int j){
        E tmp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
    }

    private static void shuffle(List<?> list, Random rnd){
        for(int i = list.size(); i>1; i--) {
            swap(list, i-1, rnd.nextInt(i));
        }
    }

    @Test
    public void exploreListIterators(){
        List<Integer> aList = new ArrayList<>();
        for(int i =0; i <10; i++){
            aList.add(i);
        }
    ListIterator<Integer> it = aList.listIterator(1);
    System.out.println(it.hasPrevious());
    System.out.println(it.hasNext());
    System.out.println(it.previous().intValue());
    //System.out.println(it.previous().intValue());
    System.out.println(it.next());
    System.out.println(it.next());
    assertTrue(it.hasPrevious());
    assertTrue(it.hasNext());
    }

    @Test
    public void findIndexInList(){
        List<Integer> integers = new ArrayList<>();
        for(int i=0; i<100; i++){
            integers.add(i);
        }

        Collections.shuffle(integers, new Random());
        //integers.add(146);
        int findInteger = 19;
        int getIntegerIndex = -1 ;
        for(int i = 0; i<=integers.size(); i+=10){
            if(getIntegerIndex != -1){
                break;
            }
            getIntegerIndex = integers.subList(0,i).indexOf(findInteger);
        }

    System.out.println(integers.get(99));
    System.out.println(integers.get(0));
    System.out.println(getIntegerIndex);

    }
    
    @Test
    public void dealHandTest(){
        List<Integer> deck = new ArrayList<>();
        for(int i=0; i<100; i++){
            deck.add(i);
        }
        Collections.shuffle(deck, new Random());
        List<Integer> firstHand = dealHand(deck, 5);

        assertEquals(5, firstHand.size());
        assertEquals(95, deck.size());
    }

    @Test
    public void dealDeckOfCards(){

        List<String> deck = DeckOfCards.createDeckOfCards();
        Collections.shuffle(deck);

        assertEquals(52, deck.size());

        int numHands = 4;
        int cardsPerHand = 5;

        if(numHands*cardsPerHand > deck.size()){
            System.out.println("Not enough cards");
            return;
        }

        for(int i = 0; i<numHands; i++){
            System.out.println(dealHand(deck, cardsPerHand));
        }

    }


}

