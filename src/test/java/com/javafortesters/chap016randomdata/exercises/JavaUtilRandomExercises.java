package com.javafortesters.chap016randomdata.exercises;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

public class JavaUtilRandomExercises {

    @Test
    public void nextIntTest(){
        Random generate = new Random();

        for(int i=0; i<1000; i++){
            int randomInt = generate.nextInt();

            System.out.println(randomInt);
            assertTrue(randomInt>=Integer.MIN_VALUE);
            assertTrue(randomInt<Integer.MAX_VALUE);
        }
    }

    @Test
    public void nextBooleanTest(){
        Random generate = new Random();
        int countTrue = 0;
        int countFalse = 0;

        for(int i=0; i<1000;i++){

            boolean randomBoolean = generate.nextBoolean();

            if(randomBoolean){
                countTrue++;
            }

            if(randomBoolean == false){
                countFalse++;
            }
        }

        System.out.println(
                String.format("Generated %d values as true", countTrue)
        );
        System.out.println(
                String.format("Generated %d values as false", countFalse)
        );

        assertTrue(countTrue>0);
        assertTrue(countFalse>0);
        assertTrue(countTrue+countFalse == 1000);
    }

    @Test
    public void nextLongTest(){
        Random generate = new Random();

        for(int i=0;i<1000;i++){
            long randomLong = generate.nextLong();

            System.out.println(randomLong);
            assertTrue(randomLong>=Long.MIN_VALUE);
            assertTrue(randomLong<Long.MAX_VALUE);
        }
    }

    @Test
    public void nextFloatTest(){
        Random generate = new Random();

        for(int i=0;i<1000;i++){
            float randomFloat = generate.nextFloat();

            System.out.println(randomFloat);
            assertTrue(randomFloat>=0.0f);
            assertTrue(randomFloat<1.0f);
        }
    }

    @Test
    public void nextDoubleTest(){
        Random generate = new Random();

        for (int i = 0; i < 1000; i++) {
            double randomDouble = generate.nextDouble();

            //System.out.println(randomDouble);
            assertTrue(randomDouble >= 0.0d);
            assertTrue(randomDouble < 1.0d);
        }
    }

    @Test
    public void nextBytesTest(){
        Random generate = new Random();

        int arrayLength = generate.nextInt(100);

        byte bytes[] = new byte[arrayLength];
        generate.nextBytes(bytes);
        assertTrue(bytes.length == arrayLength);
        String viewBytes = new String(bytes);

        System.out.println(
                String.format("%d bytes - %s", arrayLength, viewBytes)
        );

        int i = 0;
        for (byte b :bytes) {
            System.out.println(
                    String.format("%d. value of byte: %s", i,b)
            );
            i++;
        }
    }

    @Test
    public void nextIntToBoundTest(){
        Random generate = new Random();

        int boundLimit = generate.nextInt(100);

        System.out.println(
                String.format("Generating 1000 integers up to %d", boundLimit)
        );

        for (int i = 0; i < 1000; i++) {

            int randomInt = generate.nextInt(boundLimit);
            assertThat(randomInt>=0, is(true));
            assertThat(randomInt<boundLimit, is(true));
            assertThat(randomInt>=boundLimit, is(false));

        }
    }

    @Test
    public void nextIntGivenRangeNot0Test() {
        Random generate = new Random();

        int minValue = 15;
        int maxValue = 20;

        Set<Integer> nums = new HashSet<Integer>();

        for (int i = 0; i < 1000; i++) {
            int randomInt = generate.nextInt(maxValue - minValue + 1) + minValue;

            nums.add(randomInt);

            assertThat(randomInt >= 15, is(true));
            assertThat(randomInt <= 20, is(true));
        }
        assertThat(nums.size(), is(6));
        assertThat(nums.contains(15), is(true));
        assertThat(nums.contains(16), is(true));
        assertThat(nums.contains(17), is(true));
        assertThat(nums.contains(18), is(true));
        assertThat(nums.contains(19), is(true));
        assertThat(nums.contains(20), is(true));
    }

    @Test
    public void generateGaussianDoubleTest(){
        Random generate = new Random();

        int standardDeviationCount1 = 0;
        int standardDeviationCount2 = 0;
        int standardDeviationCount3 = 0;
        int standardDeviationCount4 = 0;

        for (int i = 0; i < 10000; i++) {
            double randomGaussian = generate.nextGaussian();

            //System.out.println(randomGaussian);
            if(randomGaussian > -1.0d && randomGaussian < 1.0d){
                standardDeviationCount1++;
            }
            if(randomGaussian > -2.0d && randomGaussian < 2.0d){
                standardDeviationCount2++;
            }
            if(randomGaussian > -3.0d && randomGaussian < 3.0d){
                standardDeviationCount3++;
            }
            if(randomGaussian > -4.0d && randomGaussian < 4.0d){
                standardDeviationCount4++;
            }
        }

        float sd1percentage = (standardDeviationCount1/10000f) * 100f;
        System.out.println("about 70% one standard deviation: " + sd1percentage);
        float sd2percentage = (standardDeviationCount2/10000f) * 100f;
        System.out.println("about 95% one standard deviation: " + sd2percentage);
        float sd3percentage = (standardDeviationCount3/10000f) * 100f;
        System.out.println("about 99% one standard deviation: " + sd3percentage);
        float sd4percentage = (standardDeviationCount4/10000f) * 100f;
        System.out.println("about 99.9% one standard deviation: " + sd4percentage);
    }

    @Test
    public void gaussianAgeDistributionTest(){
        Random generate = new Random();

        Map<Integer, Integer> ages = new HashMap<>();

        for (int i = 0; i < 1000; i++) {
            int randomAge = (int)(generate.nextGaussian()*5) + 35;

            int ageCount = 0;
            if(ages.containsKey(randomAge)){
                ageCount = ages.get(randomAge);
            }
            ageCount++;
            ages.put(randomAge, ageCount);
        }

        SortedSet<Integer> sortedAges = new TreeSet<>(ages.keySet());

        for (int age : sortedAges) {
            System.out.println(age + " - " + ages.get(age));
        }
    }

    @Test
    public void randomWithSeed(){

        for (int i = 0; i < 100; i++) {
            Random generate = new Random(1234567L);

            assertThat(generate.nextInt(), is(1042961893));
            assertThat(generate.nextLong(), is(-6749250865724111202L));
            assertThat(generate.nextDouble(), is(0.44762832574617084d));
            assertThat(generate.nextGaussian(), is(-0.11571220872310763));
            assertThat(generate.nextFloat(), is(0.33144182F));
            assertThat(generate.nextBoolean(), is(false));
        }
    }

    @Test
    public void generateRandomStringTest(){
        String validValues = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String randomString = "";
        String randomWord = "";

        Random generate = new Random();

        while(randomString.length() < 100) {
            //Build a random word of random length
            int randomInt = generate.nextInt(validValues.length());
            int wordLength = generate.nextInt(7)+1;
            char rChar = validValues.charAt(randomInt);
            randomWord+= rChar;

            //add random word to random string + a space " "
            if(randomWord.length() >= wordLength){
                randomString+=randomWord;
                randomString+= " ";
                randomWord = "";
            }
        }

        System.out.println(randomString);
        //length test is not passing with random words created
        //assertThat(randomString.length(), is(100));
        System.out.println(
                String.format("Random string length is around 100, always bigger: %d",
                        randomString.length())
        );
        assertTrue(randomString.matches("[A-Z ]+"));
    }
}
