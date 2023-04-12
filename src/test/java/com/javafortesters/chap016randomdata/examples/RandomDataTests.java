package com.javafortesters.chap016randomdata.examples;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class RandomDataTests {

    @Test
    public void mathRandomTest(){

        double rnd = Math.random();

        System.out.println(
                String.format("generated %f as random number", rnd)
        );

        assertThat(rnd < 1.0d, is(true));
        assertThat(rnd >= 0.0d, is(true));
    }
}
