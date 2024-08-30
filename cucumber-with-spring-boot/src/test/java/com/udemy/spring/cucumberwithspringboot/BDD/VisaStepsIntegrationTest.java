package com.udemy.spring.cucumberwithspringboot.BDD;

import com.udemy.spring.cucumberwithspringboot.BDD.configuration.SpringIntegrationTest;
import com.udemy.spring.cucumberwithspringboot.page.spring_boot_data_jpa.visa.VisaRegistrationPage;
import com.udemy.spring.cucumberwithspringboot.spring_configurations.custom_annotation.LazyAutowired;
import com.udemy.spring.cucumberwithspringboot.spring_configurations.util.LoggingService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.util.StringUtils;
import org.testng.Assert;

import java.time.LocalDate;

//@TestPropertySource(properties = "browser=firefox") // FIXME: Won't work
/**
 * FIXME: @TestPropertySource(properties = "browser=firefox") do not work. We can do that with tagged hooks. WebDriverFactory can be autowired wherever we need.
 * This limitation is not because of Spring Boot. It is because of BDD/Cucumber organizing things.
 * Imagine this scenario. I have 3 step definitions as shown here. I have distributed my steps in multiple stepdef classes like this. *
 * StepDef1 (browser=chrome)
 * -- launch
 * StepDef2 (browser=firefox)
 * -- searchkeyword
 * StepDef3
 * -- verifyresult
 * Now each step def has their own browser, How can we continue with this test if I would like to perform these steps?
 *
 * launch
 * searchkeyword
 * verifyresult
 * So, for your case, you can use factory class where it makes perfect sense.
 *
 * TODO: But other than 'browser' property, we can give a try to set some other property
 */
public class VisaStepsIntegrationTest extends SpringIntegrationTest {
    @LazyAutowired
    private VisaRegistrationPage registrationPage;
    @LazyAutowired
    private LoggingService logger;

    @Given("I am on VISA registration form")
    public void launchSite() {
        logger.info("Launching visa site");
        this.registrationPage.goTo();
        Assert.assertTrue(this.registrationPage.isAt());
    }

    @When("I select my from country {string} and to country {string}")
    public void selectCountry(String from, String to) {
        logger.info("Select countries");
        this.registrationPage.setCountryFromAndTo(from, to);
    }

    @And("I enter my dob as {string}")
    public void enterDob(String dob) {
        logger.info("Enter DOB");
        this.registrationPage.setBirthDate(LocalDate.parse(dob));
    }

    @And("I enter my name as {string} and {string}")
    public void enterNames(String fn, String ln) {
        logger.info("Enter Names");
        this.registrationPage.setNames(fn, ln);
    }

    @And("I enter my contact details as {string} and {string}")
    public void enterContactDetails(String email, String phone) {
        logger.info("Enter contact details");
        this.registrationPage.setContactDetails(email, phone);
    }

    @And("I enter the comment {string}")
    public void enterComment(String comment) {
        logger.info("Enter comments");
        this.registrationPage.setComments(comment);
    }

    @And("I submit the form")
    public void submit() {
        logger.info("Submit the application form");
        this.registrationPage.submit();
    }

    @Then("I should see get the confirmation number")
    public void verifyConfirmationNumber() {
        logger.info("Verifying confirmation number");
        boolean isEmpty = StringUtils.isEmpty(this.registrationPage.getConfirmationNumber().trim());
        Assert.assertFalse(isEmpty);
    }

    @Then("I close the browser")
    public void closeBrowser() {
        logger.info("Closing the browser");
        this.registrationPage.close();
    }
}
