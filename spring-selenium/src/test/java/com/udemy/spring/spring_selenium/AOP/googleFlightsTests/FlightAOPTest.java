package com.udemy.spring.spring_selenium.AOP.googleFlightsTests;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTests;
import com.udemy.spring.spring_selenium.page.googleflights.flightdatapropertysource.FlightInfoProperties;
import com.udemy.spring.spring_selenium.page.googleflights.page.FlightWebPageWithAOP;
import com.udemy.spring.spring_selenium.spring_configurations.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Implement Aspect Oriented Programming -- AOP Assignment
 * Requirement is to get labels of flights and take screenshot
 */
public class FlightAOPTest extends SpringBaseTestNGTests {
    @Autowired
    private FlightInfoProperties flightInfoProperties;

    @Autowired
    private FlightWebPageWithAOP flightPage;

    @BeforeSuite
    public void setup() {
        CommonUtil.deleteAllImages();
    }

    @Test
    public void flightTest() {
        this.flightPage.goTo(this.flightInfoProperties.getUrl());
        Assert.assertTrue(this.flightPage.isAt());
        Assert.assertEquals(this.flightPage.getLabels(), this.flightInfoProperties.getLabels());
    }

    @AfterTest
    public void tearDown() {
        this.flightPage.close();
    }
}
