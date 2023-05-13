package com.javafortesters.chap020mathandbigdecimal.examples;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.fail;

public class MathAndBigDecimalExamplesTest {

    @Test
    public void addingFractions(){

        try {
            float total = 0.1f + 0.73f;
            assertThat(total).isEqualTo(0.83f);
        }catch(AssertionError e){
            //Expecting test to fail because of rounding float
           System.out.println("Assertion error on rounding float");
            System.out.println(e);
        }

        BigDecimal bdTotal = new BigDecimal("0.1").add(new BigDecimal("0.73"));
        assertThat(bdTotal).isEqualTo(new BigDecimal("0.83"));
    }

    @Test
    public void canReturnMaxFromArray(){
        int[] intArray = {0,4,3,5,1,2,9,6,7,8};

        assertThat(returnMaxFromArray(intArray)).isEqualTo(9);
    }

    private int returnMaxFromArray(int[] intArray) {
        int maxInt = 0;

        for (int i: intArray) {
           maxInt = Math.max(i, maxInt);
            }
        
        return maxInt;
    }

}
