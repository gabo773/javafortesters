package com.javafortesters.chap017datesandtimes.examples;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.*;

public class DatesAndTimesExamplesTests {

    @Test //AssertJ example
    public void a_few_simple_assertions() {
        assertThat("The Lord of the Rings").isNotNull()
                .startsWith("The")
                .contains("Lord")
                .endsWith("Rings");
    }

    @Test
    public void javaCurrentTimeTests(){
        long currentTime = System.currentTimeMillis();
        long nanoCurrentTime = System.nanoTime();

        System.out.println(currentTime + "\n" + nanoCurrentTime );
    }

    @Test
    public void canCalculateExecutionTime(){
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            System.out.println(System.currentTimeMillis());
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime-startTime;

        System.out.println("Execution Time: " + executionTime);

        assertThat(executionTime).isNotNull();
    }

    @Test
    public void dateJavaModuleTests(){
        Date equivDate1 = new Date();
        Date equivDate2 = new Date(System.currentTimeMillis());

        assertThat(equivDate1).isEqualTo(equivDate2);
        System.out.println(equivDate1);
        System.out.println(equivDate2);

        Date date = new Date();
        long oneWeekFromNowTime = date.getTime();
        oneWeekFromNowTime += (1000*60*60*24*7);

        Date oneWeekFromNow = new Date(oneWeekFromNowTime);
        Date sameDate = new Date();
        sameDate.setTime(oneWeekFromNowTime);

        assertThat(sameDate.equals(oneWeekFromNow)).isTrue();
        assertThat(sameDate.compareTo(oneWeekFromNow)).isEqualTo(0);

        System.out.println(oneWeekFromNow.toString());
        System.out.println(sameDate.toString());
    }

    @Test
    public void canUseSDFPattern(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat();

        sdf.applyPattern("yyy/MMMM/dd");
        System.out.println("Date in format Year/Month/Day: " + sdf.format(date));

        sdf.applyPattern("y MMMM dd hh:mm:ss.S EEEE a");
        System.out.println("Format date with all elements: " + sdf.format(date));

        sdf.applyPattern("ww WW D FF uu k H z Z X");
        System.out.println("Format date with less used options: " + sdf.format(date));
    }

    @Test
    public void canUseCalendarTest(){
        Calendar cal = Calendar.getInstance();

        assertThat(cal.getTime().getTime()/1000)
                .isEqualTo(System.currentTimeMillis()/1000);

        Calendar sameDate = Calendar.getInstance();
        sameDate.setTime(cal.getTime());
        assertThat(cal.equals(sameDate)).isTrue();
        assertThat(cal.compareTo(sameDate)).isEqualTo(0);

        Calendar oneWeekFromNow = Calendar.getInstance();
        oneWeekFromNow.add(Calendar.DATE, 7);
        assertThat(oneWeekFromNow.after(cal)).isTrue();
        assertThat(cal.before(oneWeekFromNow)).isTrue();
        assertThat(oneWeekFromNow.compareTo(cal)).isEqualTo(1);
        assertThat(cal.compareTo(oneWeekFromNow)).isEqualTo(-1);
    }

}