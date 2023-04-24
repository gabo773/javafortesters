package com.javafortesters.chap017datesandtimes.exercises;

import org.junit.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class DatesAndTimesExercisesTests {

    @Test
    public void canCalculateExecutionTimeInNanoSeconds(){
        long startTime = System.nanoTime();

        for (int i = 0; i < 10; i++) {
            System.out.println(
                    System.nanoTime()
            );
        }

        long endTime = System.nanoTime();

        assertThat(endTime-startTime).isNotNull()
                .isGreaterThan(0);

        System.out.println("Execution time: " + (endTime-startTime));
    }

    @Test
    public void canCreateUniqStringWithTime(){
        String initialUserID = "user" + System.currentTimeMillis();
        String userId = initialUserID;

        for (int i = 0; i < 10; i++) {
            String charReplacement = "" +((char)('A' + i));
            String intToReplace = String.valueOf(i);

            userId = userId.replace(intToReplace, charReplacement);
        }

        assertThat(userId).doesNotMatch("[0-9]");
        assertThat(userId.length()).isEqualTo(initialUserID.length());

        System.out.println(userId);
    }

    @Test
    public void canUseToStringOnCalendarObject(){
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.toString());
    }
}
