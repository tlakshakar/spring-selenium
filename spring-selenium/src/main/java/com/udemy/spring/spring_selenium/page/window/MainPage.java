package com.udemy.spring.spring_selenium.page.window;

import com.udemy.spring.spring_selenium.page.Base;
import com.udemy.spring.spring_selenium.spring_configurations.custom_annotation.PageAnnotations;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@PageAnnotations
public class MainPage extends Base {
    @FindBy(tagName = "a")
    private List<WebElement> links;

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/window/main.html");
    }

    public void launchAllWindows() {
        /*this.links.forEach(webElement -> {
            webElement.click();
        });*/
        for(int ii=0;ii<this.links.size();ii++) {
            this.links.get(ii).click();
            this.webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(ii + 2));
        }
    }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until((d) -> !this.links.isEmpty());
    }
}
