package com.javafortesters.chap019files.examples;

import org.junit.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class JavaFilesTest {

    private File writeTheTestDataFile() throws IOException {
        File outputFile = File.createTempFile("forReading", null);

        PrintWriter print = new PrintWriter(
                                    new BufferedWriter(
                                            new FileWriter(outputFile)));

        for (int lineNumber = 0; lineNumber < 6; lineNumber++) {
            print.println("line number " + lineNumber);
        }

        print.close();
        return outputFile;
    }

    @Test
    public void outputFileToSystemOutWithBufferedReader() throws IOException {
        File inputFile = writeTheTestDataFile();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        try{ String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);}
        }finally {
                reader.close();
            }
    }

    @Test
    public void separatorAndPathSeparatorAndRoots(){
        assertTrue("Unrecognised OS file separator",
                File.separator.equals("\\")||
                        File.separator.equals("/"));

        assertTrue("Unrecognised OS path separator",
                File.pathSeparator.equals(";") ||
                        File.pathSeparator.equals(":"));

        File roots[] = File.listRoots();
        for (File root:roots) {
            System.out.println(root);
        }
    }

    @Test
    public void canCreateAndDeleteFile() throws IOException {
        String filePath = System.getProperty("user.dir");
        File aTempFile = new File(filePath, "tempfile.txt");

        assertThat(aTempFile.exists()).isFalse();

        aTempFile.createNewFile();
        assertThat(aTempFile.exists()).isTrue();

        aTempFile.delete();
        assertThat(aTempFile.exists()).isFalse();
    }

    @Test
    public void mkdirVersusMkdirs(){
        String tempDirectory = System.getProperty("java.io.tmpdir");
        String newDirectory = tempDirectory +
                                System.currentTimeMillis() +
                                File.separator +
                                System.currentTimeMillis();
        File aTempDirectory = new File(newDirectory);

        assertThat(aTempDirectory.mkdir()).isFalse();
        assertThat(aTempDirectory.mkdirs()).isTrue();
    }

    @Test
    public void canWriteAndReadATempFile() throws IOException {
        File outputFile = File.createTempFile("output_file", ".txt");

        PrintWriter printer = new PrintWriter(
                                    new BufferedWriter(
                                            new FileWriter(outputFile)));

        printer.println("Simple Print with PrintWriter");
        printer.println("+++++++++++++++++++++++++++++");
        for (int lineNumber = 0; lineNumber < 10; lineNumber++) {
            printer.println(lineNumber + " Add a new line");
        }
        printer.close();

        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
