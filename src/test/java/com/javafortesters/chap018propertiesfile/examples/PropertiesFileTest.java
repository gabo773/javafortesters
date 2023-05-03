package com.javafortesters.chap018propertiesfile.examples;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class PropertiesFileTest {

    @Test
    public void propertiesAndPropertyFile(){
        Properties properties = new Properties();

        assertThat(properties.size()).isEqualTo(0);

        properties.setProperty("browser", "firefox");
        properties.setProperty("port", "80");

        assertThat(properties.getProperty("browser")).isEqualTo("firefox");
        assertThat(properties.getProperty("port")).isEqualTo("80");
        assertThat(properties.getProperty("missing")).isNull();

        assertThat(properties.getProperty("missing", "not set"))
                .isEqualTo("not set");

        for( String key : properties.stringPropertyNames()){
            System.out.println(key + "=" + properties.getProperty(key));
        }

        properties.list(System.out);

        assertThat(properties.containsKey("browser")).isTrue();
        assertThat(properties.containsKey("port")).isTrue();

    }

    @Test
    public void canStoreDataInAPropertiesFile() throws IOException {
        String tempDirectory = System.getProperty("java.io.tmpdir");
        String tempResourcesFilePath =
                tempDirectory +
                        "tempFileForStorePropertiesTest.properties";

        Properties saved = new Properties();
        saved.setProperty("prop1", "Hello");
        saved.setProperty("prop2", "World");

        FileOutputStream outputFile = new FileOutputStream(tempResourcesFilePath);

        saved.store(outputFile, "Hello There World");
        outputFile.close();

        FileReader propertyFileReader = new FileReader(tempResourcesFilePath);

        Properties loaded = new Properties();
        try{
            loaded.load(propertyFileReader);
        }finally {
            propertyFileReader.close();
        }

        assertThat(loaded.getProperty("prop1")).isEqualTo("Hello");
        assertThat(loaded.getProperty("prop2")).isEqualTo("World");

        new File(tempResourcesFilePath).delete();
    }
}
