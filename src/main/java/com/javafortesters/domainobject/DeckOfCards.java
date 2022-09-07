package com.javafortesters.domainobject;

import java.util.ArrayList;
import java.util.List;

public class DeckOfCards {

    public DeckOfCards(){
        ArrayList<String> deck = new ArrayList<String>();
    };

    public static List<String> createDeckOfCards(){
        //Create a 52-card deck
        String[] suite = {
                "spades", "hearts",
                "clubs", "diamonds"
        };

        String[] value = {
                "ace", "king", "queen", "jack",
                "10", "9", "8", "7", "6", "5",
                "4", "3", "2"
        };

        List<String> deck = new ArrayList<>();

        for(String i : suite){
            for(String j : value){
                deck.add(j + " of " + i);
            }
        }

        return deck;
    }

    public static <E> List<E> dealHand(List<E> deck, int handSize) {
        int deckSize = deck.size();
        List<E> handView = deck.subList(deckSize-handSize, deckSize);
        List<E> hand = new ArrayList<>(handView);
        handView.clear();
        return hand;
    }
}
