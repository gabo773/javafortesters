package com.javafortesters.chap018propertiesfile.examples;

import org.junit.Test;

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
    }
}
