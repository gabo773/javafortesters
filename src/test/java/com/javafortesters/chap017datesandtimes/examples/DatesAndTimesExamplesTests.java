package com.javafortesters.chap017datesandtimes.examples;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Year;
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

        assertThat(cal.getTime().getTime()/10000)
                .isEqualTo(System.currentTimeMillis()/10000);

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

        cal.set(Calendar.YEAR, 2014);
        cal.set(Calendar.MONTH, Calendar.JULY);
        cal.set(Calendar.DAY_OF_MONTH, 23);
        cal.set(Calendar.HOUR, 6);
        cal.set(Calendar.AM_PM, Calendar.AM);
        cal.set(Calendar.MINUTE, 41);
        cal.set(Calendar.SECOND, 49);
        //cal.set(Calendar.MILLISECOND, 119);

        sameDate.set(2014, 6, 23, 6, 41, 49);
        assertThat(cal.equals(sameDate)).isTrue();
        assertThat(cal.get(Calendar.MONTH)).isEqualTo(6);
        assertThat(cal.get(Calendar.MINUTE)).isEqualTo(41);
        System.out.println(cal.getTime());
        System.out.println(sameDate.getTime());
    }

    @Test
    public void calenderInDateAndLong(){
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        long currentTime = System.currentTimeMillis();

        //assertThat(cal.getTime()).isEqualTo(date);
        //assertThat(cal.getTimeInMillis()).isEqualTo(currentTime);

        System.out.println(cal.getTime());
        System.out.println(date);

        System.out.println(cal.getTimeInMillis());
        System.out.println(currentTime);
    }

}