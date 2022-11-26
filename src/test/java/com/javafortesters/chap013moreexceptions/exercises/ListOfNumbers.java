package com.javafortesters.chap013moreexceptions.exercises;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ListOfNumbers {
    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers () {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++)
            list.add(new Integer(i));
    }
    public void writeList() {
        PrintWriter out = null;

        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("OutFile.txt"));

            for (int i = 0; i < SIZE; i++)
                out.println("Value at: " + i + " = " + list.get(i));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                    e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }

    public void readList(File file){
        String line = null;
        try{
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            while((line = raf.readLine()) != null){
                Integer i = new Integer(Integer.parseInt(line));
                System.out.println(i);
            }
        }catch (FileNotFoundException fnf){
            System.err.format("File %s not found", file.toString());
        }catch (IOException e){
            System.err.println(e.toString());
            System.err.println(e.getMessage());
        }
    }
}
