package com.udemy.spring.spring_selenium.resourcesTests.propertiesTests;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

@Ignore
public class ReadPropertiesTest extends SpringBaseTestNGTests {
    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    public void readProperties() throws IOException {
        /**
         * The loadProperties method reads the properties from the given resource and loads them into a Properties object.
         * This method handles the input stream and ensures the properties are correctly loaded.
         */
        Properties props = PropertiesLoaderUtils.loadProperties(
                resourceLoader.getResource("data/my.properties") // This part of the code uses the resourceLoader to get a resource located at "data/my.properties".
        );
        System.out.println(props);
    }
}
