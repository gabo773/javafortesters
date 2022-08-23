package com.javafortesters.chap008selectionsanddecisions.examples;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestSelectionDecisions {

    @Test
    public void catOrCats(){
        //int catsNumber = 1;
        //String catOrCats = catsNumber > 1 ? "cats" : "cat";
        // moved to a separate method

        assertEquals("1==cat",
                "cat",
                catOrCats(1));
        assertEquals("2==cats",
                "cats",
                catOrCats(2));
    }

    private String catOrCats(int numberOfCats) {
        return numberOfCats > 1 ? "cats" : "cat";
    }

    @Test
    public void ifTrueAssertTrue(){
        boolean truthy = false;
        if (truthy) {assertTrue(truthy);}

        if (truthy) {assertFalse(!truthy);}
    }

    @Test
    public void ifElseAssert(){
        boolean truthy = false;

        if (truthy) {assertTrue(truthy);
            assertFalse(!truthy);
        }else {assertFalse(truthy);}
    }

    @Test
    public void ifElseNestedHorror(){
        boolean truthy = false;
        boolean falsely = false;

        if (truthy){
            if (!falsely){
                if (truthy && !falsely){
                    if(falsely || truthy) {
                        assertTrue(truthy);
                        assertFalse(falsely);
                    }
                }
            }else{
                assertTrue(truthy);
                assertTrue(falsely);
            }
        }else{
            if (!truthy){
                if (falsely){
                    assertFalse(truthy);
                    assertTrue(falsely);
                }else{
                    assertFalse(truthy);
                    assertFalse(falsely);
                }
            }
        }
    }

    @Test
    public void switchOnShortCode(){
        assertEquals("United Kingdom", countryFromShortCode("UK"));
        assertEquals("United Kingdom", countryFromShortCode("Uk"));
        assertEquals("United Kingdom", countryFromShortCode("uk"));
        assertEquals("United Kingdom", countryFromShortCode("uK"));
        assertEquals("United States", countryFromShortCode("USA"));
        assertEquals("United States", countryFromShortCode("US"));
        assertEquals("France", countryFromShortCode("FR"));
        assertEquals("Sweden", countryFromShortCode("SE"));
        assertEquals("Romania", countryFromShortCode("RO"));
        assertEquals("Rest of the World", countryFromShortCode("HU"));
    }

    private String countryFromShortCode(String shortCode) {
        switch (shortCode.toLowerCase()){
            case "uk":
                return "United Kingdom";
                //break;
            case "usa":
            case "us":
                return "United States";
                //break;
            case "fr":
                return "France";
                //break;
            case "se":
                return "Sweden";
                //break;
            case "ro":
                return "Romania";
                //break;
            default:
                return "Rest of the World";
                //break;
        }
    }

    @Test
    public void switchOnInt(){
        assertEquals(intToString(1), "One");
        assertEquals(intToString(2), "Two");
        assertEquals(intToString(3), "Three");
        assertEquals(intToString(4), "Four");
        assertEquals(intToString(5), "Too big");
        assertEquals(intToString(10), "Too big");
        assertEquals(intToString(99), "Too big");
        assertEquals(intToString(0), "Too little");
        assertEquals(intToString(-10), "Too little");
    }

    private String intToString(int intToSwitch) {
        if (intToSwitch<=4) {
            switch (intToSwitch) {
                default:
                    return "Too little";
                case 1:
                    return "One";
                case 2:
                    return "Two";
                case 3:
                    return "Three";
                case 4:
                    return "Four";
            }
        }else{
            return "Too big";
            }
    }

}
