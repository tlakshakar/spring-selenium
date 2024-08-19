package com.udemy.spring.spring_selenium.page.window;

import com.udemy.spring.spring_selenium.page.Base;
import com.udemy.spring.spring_selenium.spring_configurations.custom_annotation.PageAnnotations;
import com.udemy.spring.spring_selenium.spring_configurations.custom_annotation.WindowAnnotations;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//@PageAnnotations
@WindowAnnotations("Page A") // AOP - Aspect Oriented Programming
// Even if the title of the page is long—for example, ‘Page A AWS Billing and Cost Management console’—and it starts with ‘Page A,’ we’ve already implemented handling for such cases under the WindowSwitchService
public class PageA extends Base {
    @FindBy(css = "body > h1")
    private WebElement header;
    @FindBy(name = "fn")
    private WebElement firstName;
    @FindBy(name = "ln")
    private WebElement lastName;
    @FindBy(name = "addr")
    private WebElement address;
    @FindBy(css = "#area")
    private WebElement textArea;

    @Override
    public boolean isAt() {
        JavascriptExecutor jse = (JavascriptExecutor) this.driver;
        return this.webDriverWait.until((d) -> jse.executeScript("return document.readyState").equals("complete"));
    }

    public void enterPageAInfo(final String firstName, final String lastName, final String address, final String message) {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);
        this.lastName.clear();
        this.lastName.sendKeys(lastName);
        this.address.clear();
        this.address.sendKeys(address);
        //this.textArea.clear();
        this.textArea.sendKeys(message);
    }
}
