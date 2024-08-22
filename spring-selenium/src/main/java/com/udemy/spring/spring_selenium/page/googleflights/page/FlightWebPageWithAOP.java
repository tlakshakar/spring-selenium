package com.udemy.spring.spring_selenium.page.googleflights.page;

import com.udemy.spring.spring_selenium.page.Base;
import com.udemy.spring.spring_selenium.spring_configurations.custom_annotation.Loggable;
import com.udemy.spring.spring_selenium.spring_configurations.custom_annotation.PageAnnotations;
import com.udemy.spring.spring_selenium.spring_configurations.custom_annotation.TakeScreenshotAnnotations;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Implement Aspect Oriented Programming -- AOP
 * Spring AOP uses proxy-based mechanisms. If you’re invoking the methods within the same class (e.g., calling goTo from another method in FlightWebPageWithAOP), the aspect won’t be applied.
 */
@PageAnnotations
public class FlightWebPageWithAOP extends Base {
    private JavascriptExecutor jse;
    @FindBy(css = "[aria-label='Flight']")
    private WebElement flightSearch;
    @FindBy(xpath = ".//*[@data-is-touch-wrapper='true']//*[@role='link']//span")
    private List<WebElement> buttons;

    @Override
    @Loggable("isAt()")
    public boolean isAt() {
        jse = (JavascriptExecutor) driver;
        boolean isLoaded = this.webDriverWait.until((driver) -> jse.executeScript("return document.readyState").equals("complete"));
        boolean isNotEmpty = this.webDriverWait.until((d) -> !this.buttons.isEmpty());
        return (isLoaded && isNotEmpty);
    }

    @Loggable("getLabels()")
    @TakeScreenshotAnnotations
    public List<String> getLabels() {
        return this.buttons.stream() // Converts the 'buttons' collection into a stream, allowing for functional-style operations.
                .map(WebElement::getText) // Extracts the text content from each button, resulting in a stream of strings.
                .filter(Objects::nonNull) // Ensure no null values
                .map(String::trim) // Removes any leading and trailing whitespace from each string.
                .collect(Collectors.toList()); // Collects the processed stream elements into a List<String> and returns it.
    }

    @Loggable("goTo()")
    public void goTo(final String url) {
        this.driver.get(url);
        this.driver.manage().window().maximize();
    }

    @Loggable("close()")
    public void close() {
        this.driver.quit();
    }
}
