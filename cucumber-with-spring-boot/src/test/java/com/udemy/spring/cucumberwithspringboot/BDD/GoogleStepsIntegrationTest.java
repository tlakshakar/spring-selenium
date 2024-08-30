package com.udemy.spring.cucumberwithspringboot.BDD;

import com.udemy.spring.cucumberwithspringboot.BDD.configuration.SpringIntegrationTest;
import com.udemy.spring.cucumberwithspringboot.page.google.GooglePage;
import com.udemy.spring.cucumberwithspringboot.spring_configurations.custom_annotation.LazyAutowired;
import com.udemy.spring.cucumberwithspringboot.spring_configurations.util.LoggingService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

public class GoogleStepsIntegrationTest extends SpringIntegrationTest {
    @LazyAutowired
    private GooglePage googlePage;
    @LazyAutowired
    private LoggingService logger;

    @Given("I am on the google site")
    public void launchSite() {
        logger.info("Launching Site");
        this.googlePage.goTo();
    }

    @When("I enter {string} as a keyword")
    public void enterKeyword(String keyword) {
        logger.info("Enter keyword: "+keyword);
        this.googlePage.getSearchComponent().clearSearchBox();
        this.googlePage.getSearchComponent().search(keyword);
    }

    @Then("I should see search results page")
    public void clickSearch() {
        logger.info("Click on search button");
        Assert.assertTrue(this.googlePage.getSearchComponent().isAt());
    }

    @Then("I should see at least {int} results")
    public void verifyResults(int count) {
        logger.info("Verifying the results");
        Assert.assertTrue(this.googlePage.getSearchResultComponent().getCount() >= count);
    }

    @Then("I quit the browser")
    public void closeBrowser() {
        logger.info("Closing the browser");
        this.googlePage.close();
    }
}
