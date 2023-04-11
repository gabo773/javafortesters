package com.javafortesters.chap015stringrevisited.examples;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class StringObjectRevisitedTests {

    @Test
    public void stringObjectTests(){

        String aString = "12345";

        assertThat(aString.length(), is(5));
        assertEquals(aString, "12"+"34"+"5");
    }

    @Test
    public void stringConcatTests() {
        String thisIs = "This is ";

        int i = 4;
        String s1 = thisIs.concat(Integer.toString(i));
        assertEquals("This is 4", s1);

        boolean b = true;
        String s2 = thisIs.concat(Boolean.toString(b));
        assertThat(s2, is("This is true"));

        int j = 7;
        String s3 = thisIs.concat(String.valueOf(j));
        assertThat(s3, is("This is 7"));

        boolean c = false;
        String s4 = thisIs.concat(String.valueOf(c));
        assertThat(s4, is("This is false"));

        assertThat(nullValue().toString(), is("null"));

        assertThat(Integer.valueOf("2"), is(2));
        assertThat(Boolean.valueOf("true"), is(true));

        char chArray[] = {'2', '3'};
        assertThat("23".toCharArray(), is(chArray));
    }

    @Test
    public void canConvertBytesUTF8() throws UnsupportedEncodingException {

        byte b8Array[] = "Gaboolean Analytica".getBytes("UTF8");
        for(byte b : b8Array){
            System.out.println(b);
        }
    }

    @Test
    public void stringComparison(){
        String hello = "Hello";
        assertThat(hello.compareTo("Hello"), is(0));

        assertThat(hello.compareTo("hello")<0, is(true));
        assertThat(hello.compareTo("helo")<0, is(true));
        assertThat(hello.compareTo("heo")<0, is(true));

        assertThat(hello.compareTo("HEllo")>0, is(true));
        assertThat(hello.compareTo("H")>0, is(true));
        assertThat(hello.compareTo("Hellnm")>0, is(true));

        assertThat(hello.compareToIgnoreCase("heLLo"), is(0));
        assertThat(hello.compareToIgnoreCase("hello"), is(0));
        assertThat(hello.compareToIgnoreCase("hEllO"), is(0));

        assertThat(hello.compareToIgnoreCase("hElln")>0, is(true));
        assertThat(hello.compareToIgnoreCase("hEllp")<0, is(true));

        assertThat(hello.contains("ll"), is(true));
        assertThat(hello.contains("o"), is(true));
        assertThat(hello.contains("HE"), is(false));

        assertThat(hello.equalsIgnoreCase("hello"), is(true));
        assertThat(hello.equals("hello"), is(false));

        assertThat(hello.toLowerCase().startsWith("he".toLowerCase()), is(true));
        assertThat(hello.endsWith("LO".toLowerCase()), is(true));
    }

    @Test
    public void stringRegionMatchesMethodExample(){
        String s1 = "hello fella";
        assertThat(s1.regionMatches(true, 6, "FEZ", 0, 2),
                    is(true));

        System.out.println(s1);
    }

    @Test
    public void stringIndexes(){
        String hello = "Hello fella";

        assertThat(hello.indexOf("l"), is(2));
        assertThat(hello.lastIndexOf("l"), is(9));

        assertThat(hello.indexOf("l", 3), is(3));
        assertThat(hello.indexOf("l", 8), is(8));

        assertThat(hello.lastIndexOf('l', 8), is(8));
        assertThat(hello.lastIndexOf('l', 6), is(3));

        assertThat(hello.indexOf(2), is(-1));
        assertThat(hello.lastIndexOf(2), is(-1));
    }

    @Test
    public void stringMoreExampleTests(){
        String s1 = "  trim  ";

        assertThat(s1.trim(), is("trim"));

        String digits = "0123456789";

        assertThat(digits.substring(5), is("56789"));
        assertThat(digits.substring(5, 6), is("5"));

        int value = 4;
        String template = "The value %d was used";
        String formatted = String.format(template, value);

        assertThat(formatted, is("The value 4 was used"));

        String use = "%s %s towards %s large %s.";
        assertThat(String.format(use, "Bob", "ran", 4, "onions"),
                is("Bob ran towards 4 large onions."));

        String txt = "%4$s %2$s towards %1$s large %3$d.";
        assertThat(String.format(txt, "Bob", "ran", 4, "onions"),
                is("onions ran towards Bob large 4."));

        String txt2 = "%1$s %1$s towards %3$s large %1$s.";
        assertThat(String.format(txt2, "Bob", "ran", 6, "onions"),
                is("Bob Bob towards 6 large Bob."));

        String s2 = "1, 2, 3, 4, 5, 6, 7, 8, 9, 10";
        String results[] = s2.split(", ");

        assertThat(results.length, is(10));
        assertThat(Integer.valueOf(results[0]), is(1));
        assertThat(results[9], is("10"));
    }

    @Test
    public void stringBuilderTests(){

        StringBuilder builder = new StringBuilder();
        builder.ensureCapacity(5);
        builder.append("Hello There");
        builder.replace(7, 11, "World");
        builder.delete(5, 7);

        assertThat(builder.toString(), is("HelloWorld"));

        assertThat(builder.capacity(), is(16));
        builder.trimToSize();
        assertThat(builder.capacity(), is(10));

        builder.delete(0, builder.length());
        builder.append("> ");
        builder.append(1);
        builder.append(" ");
        builder.append("+ ");
        builder.append(2);
        char ca[] = {' ', '=', ' ', '3'};
        builder.append(ca);

        assertThat(builder.toString(), is("> 1 + 2 = 3"));
    }
    @Test
    public void stringBuilderInsertChar(){
        char ca[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        StringBuilder builder = new StringBuilder("abgh");
        builder.insert(2, ca, 2, 4);

        assertThat(builder.toString(), is("abcdefgh"));

        builder.delete(2,4);
        assertThat(builder.toString(), is("abefgh"));

        builder.deleteCharAt(2);
        assertThat(builder.toString(), is("abfgh"));

        builder = new StringBuilder("abcdefgh");
        builder.replace(0,4,"012345678");
        assertThat(builder.toString(), is("012345678efgh"));

        builder.delete(9, builder.length());
        builder.setCharAt(5, 'f');
        assertThat(builder.toString(), is("01234f678"));

        builder = new StringBuilder("0123456789");
        builder.reverse();
        assertThat(builder.toString(), is("9876543210"));

        builder.reverse();
        String subString = builder.substring(3,6);
        assertThat(subString, is("345"));

    }
}
