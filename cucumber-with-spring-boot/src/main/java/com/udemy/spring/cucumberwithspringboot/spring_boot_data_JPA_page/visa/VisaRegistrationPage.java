package com.udemy.spring.cucumberwithspringboot.spring_boot_data_JPA_page.visa;

import com.udemy.spring.cucumberwithspringboot.page.Base;
import com.udemy.spring.cucumberwithspringboot.spring_configurations.custom_annotation.PageAnnotations;
import com.udemy.spring.cucumberwithspringboot.spring_configurations.util.LoggingService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;

@PageAnnotations
public class VisaRegistrationPage extends Base {
    @Value("${visa.url}")
    private URL url;

    @Autowired
    private LoggingService logger; // It is a bean
    // private LoggingService logger = new LoggingService(); // No need as we already created LoggerConfig to allow Spring to manage it

    @FindBy(id = "first_4")
    private WebElement firstName;

    @FindBy(id = "last_4")
    private WebElement lastName;

    @FindBy(id = "input_46")
    private WebElement fromCountry;

    @FindBy(id = "input_47")
    private WebElement toCountry;

    @FindBy(id = "input_24_month")
    private WebElement month;

    @FindBy(id = "input_24_day")
    private WebElement day;

    @FindBy(id = "input_24_year")
    private WebElement year;

    @FindBy(id = "input_6")
    private WebElement email;

    @FindBy(id = "input_27_phone")
    private WebElement phone;

    @FindBy(id = "input_45")
    private WebElement comments;

    @FindBy(id = "submitBtn")
    private WebElement submit;

    @FindBy(id = "requestnumber")
    private WebElement requestNumber;

    @Override
    public boolean isAt() {
        return this.webDriverWait.until((d) -> this.firstName.isDisplayed());
    }

    public void goTo() {
        this.driver.get(this.url.toString());
    }

    public void setNames(String firstName, String lastName) {
        this.logger.logMessage("Getting names : " + firstName);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
    }

    public void setCountryFromAndTo(String countryFrom, String countryTo) {
        new Select(this.fromCountry).selectByValue(countryFrom);
        new Select(this.toCountry).selectByValue(countryTo);
    }

    public void setBirthDate(LocalDate localDate) {
        new Select(this.year).selectByVisibleText(String.valueOf(localDate.getYear()));
        new Select(this.day).selectByVisibleText(String.valueOf(localDate.getDayOfMonth()));
        new Select(this.month).selectByValue(localDate.getMonth().toString());
    }

    public void setContactDetails(String email, String phone) {
        this.email.sendKeys(email);
        this.phone.sendKeys(phone);
    }

    public void setComments(String comments) {
        this.comments.sendKeys(Objects.toString(comments, "")); // If comments are null/empty then default value should be ""
    }

    public void submit() {
        this.submit.click();
    }

    public String getConfirmationNumber() {
        this.webDriverWait.until((d) -> this.requestNumber.isDisplayed());
        return this.requestNumber.getText();
    }

    public void close() {
        this.driver.quit();
    }
}
