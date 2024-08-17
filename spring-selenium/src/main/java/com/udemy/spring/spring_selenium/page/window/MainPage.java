package com.udemy.spring.spring_selenium.page.window;

import com.udemy.spring.spring_selenium.page.Base;
import com.udemy.spring.spring_selenium.spring_configurations.custom_annotation.PageAnnotations;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageAnnotations
public class MainPage extends Base {
    @FindBy(tagName = "a")
    private List<WebElement> links;

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/window/main.html");
    }

    public void launchAllWindows() {
        this.links.forEach(webElement -> {
            webElement.click();
        });
    }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until((d) -> !this.links.isEmpty());
    }
}
