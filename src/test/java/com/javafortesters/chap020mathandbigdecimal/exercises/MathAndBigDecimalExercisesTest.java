package com.javafortesters.chap020mathandbigdecimal.exercises;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class MathAndBigDecimalExercisesTest {

    @Test
    public void comparisonOfOperations(){

        double doubleTotal = 5.0 - 0.43 - 0.73 - 1.73;
        int intTotal = 500 - 43 - 73 - 173;
        BigDecimal bdTotal = new BigDecimal("5").subtract(new BigDecimal("0.43"));
        bdTotal = bdTotal.subtract(new BigDecimal("0.73"));
        bdTotal = bdTotal.subtract(new BigDecimal("1.73"));

        System.out.println(doubleTotal);
        System.out.println(intTotal);
        System.out.println(bdTotal);
    }

    @Test
    public void canDoBasicOperationWithBigDecimal(){
        BigDecimal aBigDecimal = ((((new BigDecimal(0).add(new BigDecimal("10")))
                .multiply(new BigDecimal("2")))
                .subtract(new BigDecimal("10")))
                .divide(new BigDecimal("2")));

        assertThat(aBigDecimal).isEqualTo(new BigDecimal(5));
    }

    @Test
    public void compareTenAndOne(){
        BigDecimal ten = BigDecimal.TEN;
        BigDecimal one = BigDecimal.ONE;

        assertThat(ten.compareTo(one) > 0).isTrue();
        assertThat(ten.compareTo(one) < 0).isFalse();
        assertThat(one.compareTo(ten) < 0).isTrue();
        assertThat(one.compareTo(BigDecimal.ONE)).isEqualTo(0);
        assertThat(ten.compareTo(BigDecimal.TEN)).isEqualTo(0);
        assertThat(one.compareTo(ten) == 0).isFalse();
        assertThat((ten.compareTo(one)>0) || (ten.compareTo(one) == 0)).isTrue();
        assertThat((one.compareTo(ten)<0) || (one.compareTo(ten)==0)).isTrue();
    }
}
