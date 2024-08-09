package com.udemy.spring.spring_selenium.page.redbus;

import com.udemy.spring.spring_selenium.custom_annotation.PageFragment;
import com.udemy.spring.spring_selenium.page.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

//@Component // @Component by default, it will be a singleton scope. So the only one instance will be created and all the threads will be using the same instance. If you need a different scope, you can use the @Scope annotation to specify it.
@PageFragment
public class SearchResults extends Base {
    @FindBy(xpath = "//div[@class='onward d-block fl']//div[@class='h2-tag-seo']")
    public WebElement busHeaderTag;
    @FindBy(xpath = "//span[@class='f-bold busFound']")
    public WebElement countOfBuses;
    @Override
    public boolean isAt() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return this.webDriverWait.until((driver) -> js.executeScript("return document.readyState").equals("complete")
                && this.countOfBuses.isEnabled());
    }

    public String getCountOfBuses() {
        return this.countOfBuses.getText();
    }

    public String getBusHeaderTag() {
        return this.busHeaderTag.getText();
    }
}
