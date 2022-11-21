package com.javafortesters.chap013moreexceptions.exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TryingExceptions {

    public static void cat(File file) {
        RandomAccessFile input = null;
        String line = null;

        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        }catch(FileNotFoundException e){
            System.err.format("File %s not found.%n", file);
        }
        catch(IOException e){
            System.err.println(e.toString());
        } finally {
            if (input != null) {
                try {
                    input.close();
                }catch (IOException e){
                    System.err.println(e.toString());
                }
            }
        }
    }

    public static void main(String args[]){
        File file=null;
        try {
            file = File.createTempFile("test", "test");
        }catch (IOException ie){
            System.err.println(ie.toString());
        }
        cat(file);
    }
}
