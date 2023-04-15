package com.javafortesters.chap016randomdata.examples;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

public class RandomDataTests {

    @Test
    public void mathRandomTest(){

        for(int i = 0; i<100; i++){
            double rnd = Math.random();

            System.out.println(
                    String.format("%d. generated %f as random number", i, rnd)
            );

            assertThat(rnd < 1.0d, is(true));
            assertThat(rnd >= 0.0d, is(true));

        }
    }

    @Test
    public void javaUtilRandomTest(){
        Random generate = new Random();

        boolean randomBoolean = generate.nextBoolean();
        int randomInt = generate.nextInt();
        int randomIntRange = generate.nextInt(12);
        long randomLong = generate.nextLong();
        long randomLongRange = generate.nextLong();
        double randomDouble = generate.nextDouble();
        double randomGaussian = generate.nextGaussian();
        float randomFloat = generate.nextFloat();

        int arrayLength = generate.nextInt(100);
        byte bytes[] = new byte[arrayLength];
        generate.nextBytes(bytes);
        assertEquals(arrayLength, bytes.length);
        String viewBytes = new String(bytes);

        System.out.println(arrayLength + "-" + viewBytes );
    }
}
