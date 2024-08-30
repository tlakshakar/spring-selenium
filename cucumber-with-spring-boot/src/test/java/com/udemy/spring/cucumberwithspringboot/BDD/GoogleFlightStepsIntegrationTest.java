package com.udemy.spring.cucumberwithspringboot.BDD;

import com.udemy.spring.cucumberwithspringboot.BDD.configuration.SpringIntegrationTest;
import com.udemy.spring.cucumberwithspringboot.page.googleflights.flightdatapropertysource.FlightInfoProperties;
import com.udemy.spring.cucumberwithspringboot.page.googleflights.page.FlightWebPageWithAOP;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class GoogleFlightStepsIntegrationTest extends SpringIntegrationTest {
    @Autowired
    private FlightInfoProperties flightInfoProperties;

    @Autowired
    private FlightWebPageWithAOP flightPage;

    @Given("I am on the google flight site")
    public void i_am_on_the_google_flight_site() {
        this.flightPage.goTo(this.flightInfoProperties.getUrl());
    }
    @When("The page is loaded")
    public void the_page_is_loaded() {
        Assert.assertTrue(this.flightPage.isAt());
    }
    @Then("I should see labels")
    public void i_should_see_labels() {
        Assert.assertEquals(this.flightPage.getLabels(), this.flightInfoProperties.getLabels());
    }
}
