package com.javatutorials.oopconcepts.exercises;

public class HDHeadphones implements HeadPhones{

    private final String headphonesname;

    public HDHeadphones(){
        this("noname");
            }
            
    public HDHeadphones(String headphonesname){
        this.headphonesname = headphonesname;
    }

    int volume = 0;
    int power = 0;
    int bass = 0;

    public void turnOnOff(int newValue){
        power = newValue;
    }

    public void increaseVolume(int increment){
        volume += increment;
    }

    public void increaseBass(int increment){
        bass += increment;
    }

    public void decreaseVolume(int decrement){
        volume -= decrement;
    }

    public void decreaseBass(int decrement){
        bass -= decrement;
    }

    public void printStates(){
        System.out.println("name: " + headphonesname
                + " power: " + power
                + " volume: " + volume
                + " bass: " + bass);
    }

    public static void main(String[] args){
        HDHeadphones regularHP = new HDHeadphones();
        HDHeadphones sonyHeadphones = new HDHeadphones("sonys");

        sonyHeadphones.turnOnOff(1);
        sonyHeadphones.increaseVolume(10);
        sonyHeadphones.increaseBass(10);
        sonyHeadphones.increaseBass(10);

        regularHP.printStates();
        sonyHeadphones.printStates();
    }

}



