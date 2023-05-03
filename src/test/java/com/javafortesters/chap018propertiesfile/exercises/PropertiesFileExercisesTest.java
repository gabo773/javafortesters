package com.javafortesters.chap018propertiesfile.exercises;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class PropertiesFileExercisesTest {

    @Test
    public void canCreatePropertiesFile(){
        Properties properties = new Properties();

        properties.setProperty("name", "bob");
        properties.setProperty("gender", "male");
        properties.setProperty("password", "paSSw0rd");

        assertThat(properties.size()).isEqualTo(3);

        for (String key: properties.stringPropertyNames()) {
            System.out.println(key + "=" + properties.getProperty(key));
        }

        properties.list(System.out);

        assertThat(properties.containsKey("gender")).isTrue();
        assertThat(properties.getProperty("name")).isEqualTo("bob");
        assertThat(properties.getProperty("permission", "Admin"))
                .isEqualTo("Admin");
    }

    @Test
    public void canOutputSystemProperties(){
        Properties sys = System.getProperties();

        sys.list(System.out);

        boolean wd = System.getProperties().containsKey("webdriver.chrome.driver");
        System.out.println(wd);
    }

    @Test
    public void canStoreAndLoadProperties() {
        long startTime = System.currentTimeMillis();
        String tempDirectory = System.getProperty("java.io.tmpdir");
        String tempPropertiesFile =
                tempDirectory +
                        "tempPropertiesFile.properties";

        Properties tempProperties = new Properties();
        tempProperties.setProperty("browser", "brave");
        tempProperties.setProperty("port", "8080");

        try(FileOutputStream outputFile = new FileOutputStream(tempPropertiesFile)){
        tempProperties.store(outputFile, "This is not a test");
        } catch (IOException e){
            System.out.println("Storing properties to file failed");
            e.printStackTrace(System.out);
        }

        Properties loadPropFromFile = new Properties();

        try(FileReader propertiesFileReader = new FileReader(tempPropertiesFile)){
                loadPropFromFile.load(propertiesFileReader);
        }
        catch (IOException e) {
            System.out.println("Reading properties from file failed");
            e.printStackTrace(System.out);
        }
        new File(tempPropertiesFile).delete();

        assertThat(loadPropFromFile.getProperty("browser")).isEqualTo("brave");
        assertThat(loadPropFromFile.getProperty("port")).isEqualTo("8080");

        long endTime = System.currentTimeMillis();

        System.out.println("Execution time: " + (endTime-startTime)/1000.0 + "ms");
    }
}
