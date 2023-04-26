package com.javafortesters.chap017datesandtimes.exercises;

import org.junit.Test;

import java.util.Calendar;
import java.util.TimeZone;

import static org.assertj.core.api.Assertions.as;
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

    @Test
    public void canSetAndGetCalendarValues(){
        Calendar cal = Calendar.getInstance();
        cal.set(2013, Calendar.DECEMBER, 15, 23, 49, 54);

        assertThat(cal.get(Calendar.YEAR)).isEqualTo(2013);
        assertThat(cal.get(Calendar.MONTH)).isEqualTo(Calendar.DECEMBER);
        assertThat(cal.get(Calendar.DAY_OF_MONTH)).isEqualTo(15);
        assertThat(cal.get(Calendar.HOUR_OF_DAY)).isEqualTo(23);
        assertThat(cal.get(Calendar.MINUTE)).isEqualTo(49);
        assertThat(cal.get(Calendar.SECOND)).isEqualTo(54);
        assertThat(cal.get(Calendar.HOUR)).isEqualTo(11);
        assertThat(cal.get(Calendar.AM_PM)).isEqualTo(Calendar.PM);

        assertThat(cal.get(Calendar.DAY_OF_WEEK)).isEqualTo(Calendar.SUNDAY);
        assertThat(cal.get(Calendar.WEEK_OF_MONTH)).isEqualTo(3);
        assertThat(cal.get(Calendar.DAY_OF_WEEK)).isEqualTo(1);
        assertThat(cal.get(Calendar.WEEK_OF_YEAR)).isEqualTo(51);
        assertThat(cal.get(Calendar.DAY_OF_YEAR)).isEqualTo(349);
    }

    @Test
    public void canModifyDateWithAddAndRoll(){
        Calendar cal = Calendar.getInstance();

        cal.set(2013, Calendar.DECEMBER, 23, 21, 25);
        cal.add(Calendar.YEAR, -2);
        cal.add(Calendar.MONTH, -6);
        cal.add(Calendar.DAY_OF_MONTH, -12);

        assertThat(cal.get(Calendar.YEAR)).isEqualTo(2011);
        assertThat(cal.get(Calendar.MONTH)).isEqualTo(5);
        assertThat(cal.get(Calendar.DAY_OF_MONTH)).isEqualTo(11);

        cal.set(2013, Calendar.DECEMBER, 23, 21, 25);
        cal.roll(Calendar.DAY_OF_MONTH, 17);
        assertThat(cal.get(Calendar.YEAR)).isEqualTo(2013);
        assertThat(cal.get(Calendar.MONTH)).isEqualTo(11);
        assertThat(cal.get(Calendar.DAY_OF_MONTH)).isEqualTo(9);

        cal.set(2013, Calendar.DECEMBER, 23, 21, 25);
        cal.add(Calendar.DAY_OF_MONTH, 17);
        assertThat(cal.get(Calendar.YEAR)).isEqualTo(2014);
        assertThat(cal.get(Calendar.MONTH)).isEqualTo(0);
        assertThat(cal.get(Calendar.DAY_OF_MONTH)).isEqualTo(9);
    }
}
