package com.javafortesters.chap019files.exercises;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class JavaFilesExercisesTest {

    @Test
    public void canCreateTempFileWithVaryParam() throws IOException {
        File outputFile = File.createTempFile("test", ".log",
                                                new File(System.getProperty("user.dir")));
    }

    @Test
    public void canPrintRootsAbsolutPath(){
        File roots[] = File.listRoots();

        for (File root: roots) {
            System.out.println(root.getAbsolutePath());
            }
    }

    @Test
    public void canSimulateCreatingTempFile() throws IOException {
        String filePath = System.getProperty("java.io.tmpdir");
        File aTempFile = new File(filePath, "aTempFile" + System.currentTimeMillis());

        aTempFile.createNewFile();
        assertThat(aTempFile.exists()).isTrue();

        aTempFile.delete();
        assertThat(aTempFile.exists()).isFalse();
    }

    @Test
    public void absoluteVersusCanonicalPath() throws IOException {
        File aTempFile1 = new File("C:/1/2/3/4/../../..");
        File aTempFile2 = new File("C:/1/2/../../1");

        assertThat(aTempFile1.getCanonicalPath()).isEqualTo("C:\\1");
        assertThat(aTempFile2.getCanonicalPath()).isEqualTo("C:\\1");
    }

    @Test
    public void canTestIfDirectoryOrFile(){
        File aTemp = new File(System.getProperty("java.io.tmpdir"));

        assertThat(aTemp.isFile()).isFalse();
        assertThat(aTemp.isDirectory()).isTrue();
    }

    @Test
    public void canWriteToAFile() throws IOException {
        File outputFile = File.createTempFile("printWriter", null);

        PrintWriter print = new PrintWriter(outputFile);

        print.println("Simple Print with PrintWriter");
        print.close();

        FileWriter writer = new FileWriter(outputFile, true);
        BufferedWriter buffer = new BufferedWriter(writer);
        PrintWriter newPrinter = new PrintWriter(buffer);
        newPrinter.println("++++++++++++++++++++++++++");
        newPrinter.println("Add a new line");
        newPrinter.close();
        writer.close();
        buffer.close();

        String lineEnd = System.lineSeparator();
        long fileLen = 69L + lineEnd.length() + lineEnd.length() + lineEnd.length();

        assertThat(outputFile.length()).isEqualTo(fileLen);
    }

    @Test
    public void canShowContentsOfFolderAndAttributes() throws IOException {
        File tempDir = new File(System.getProperty("java.io.tmpdir"));

        File[] fileList = tempDir.listFiles();

        for (File fileInList:fileList) {
            String fileType = "";
            if (fileInList.isDirectory()) {
                fileType += "DIR: ";
            } else if (fileInList.isFile()) {
                fileType += "FIL: ";
            } else {
                throw new IOException("Unknown format, must be Dir or File");
            }


            if (fileInList.canRead()) {
                fileType += "r";
            }else{
                fileType += "-";
            }

            if (fileInList.canWrite()) {
                fileType += "w";
            }else{
                fileType += "-";
            }

            if (fileInList.canExecute()) {
                fileType += "x";
            }else{
                fileType += "-";
            }

            SimpleDateFormat sdf = new SimpleDateFormat("y M d hh:mm:ss.SSS");
            String lastModified = sdf.format(new Date(fileInList.lastModified()));

            System.out.println(fileType + " " + fileInList.getName()
                                + " last modified: " + lastModified);
        }
    }

    @Test
    public void canCopyAndMoveFile() throws IOException {
        File baseFile = File.createTempFile("baseFile", null);
        File targetFile = File.createTempFile("targetFile", ".copy");

        PrintWriter printer = new PrintWriter(
                                            new BufferedWriter(
                                                    new FileWriter(baseFile)));

        printer.println("=======================");
        printer.println("This is not a copy test");
        printer.close();

        Files.copy(baseFile.toPath(), targetFile.toPath(),
        REPLACE_EXISTING);

        File moveThis = File.createTempFile("moveThis", null);
        File toThis = File.createTempFile("toThis", ".moved");

        PrintWriter newPrinter = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(moveThis)));

        newPrinter.println("+++++++++++++++++++++++");
        newPrinter.println("This is not a move test");
        newPrinter.close();

        Files.move(moveThis.toPath(), toThis.toPath(),
                REPLACE_EXISTING, ATOMIC_MOVE);

    }


}
