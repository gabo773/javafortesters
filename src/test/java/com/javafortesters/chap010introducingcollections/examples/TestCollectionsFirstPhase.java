package com.javafortesters.chap010introducingcollections.examples;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TestCollectionsFirstPhase {

    @Test
    public void whileLoopForLoop(){

        String workdays[] = {"Monday", "Tuesday"
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

}

