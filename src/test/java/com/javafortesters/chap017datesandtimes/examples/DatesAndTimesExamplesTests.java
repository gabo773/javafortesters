package com.javafortesters.chap017datesandtimes.examples;

import org.junit.Test;
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




}
