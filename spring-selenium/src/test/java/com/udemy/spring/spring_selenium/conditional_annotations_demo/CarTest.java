package com.udemy.spring.spring_selenium.conditional_annotations_demo;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTests;
import com.udemy.spring.spring_selenium.spring_configurations.conditionalAnnotationsDemo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class CarTest extends SpringBaseTestNGTests {
    @Autowired
    @Qualifier("BMW")
    private Car car;

    @Test
    @Ignore
    public void carTest() {
        this.car.run();
        this.car.definition();
    }
}
