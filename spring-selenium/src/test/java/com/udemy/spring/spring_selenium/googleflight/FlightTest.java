package com.udemy.spring.spring_selenium.googleflight;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTests;
import com.udemy.spring.spring_selenium.page.googleflights.flightdatapropertysource.FlightInfoProperties;
import com.udemy.spring.spring_selenium.page.googleflights.page.FlightWebPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

/**
 * Requirement is to get labels of flights
 */
@Ignore
public class FlightTest extends SpringBaseTestNGTests {
    @Autowired
    private FlightInfoProperties flightInfoProperties;

    @Autowired
    private FlightWebPage flightPage;

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
