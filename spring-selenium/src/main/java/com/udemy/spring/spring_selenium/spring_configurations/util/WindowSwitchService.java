package com.udemy.spring.spring_selenium.spring_configurations.util;


import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * AOP -- Aspect Oriented Programming
 */
@Service // Similar to @Component
public class WindowSwitchService {
    private WebDriver driver;
    @Autowired
    private ApplicationContext ctx;

    public void switchWindowByTitle(final String title) {
        this.driver = this.ctx.getBean(WebDriver.class); // retrieves the WebDriver bean from the Spring context.
        this.driver.getWindowHandles()// returns a Set of all window handles.
                .stream().map(handle -> this.driver.switchTo().window(handle).getTitle()) // maps each window handle to its title
                .filter(t -> t.startsWith(title)).findFirst() // filters the titles to find one that starts with the given title.
                .orElseThrow(() -> {
                    throw new RuntimeException("No such window!!");
                });
    }

    public void switchWindowByIndex(final int index) {
        this.driver = this.ctx.getBean(WebDriver.class);
        // This converts the Set<String> to an array of String. The new String[0] is a way to specify the type of array to be returned.
        String[] handles = this.driver.getWindowHandles().toArray(new String[0]);
        driver.switchTo().window(handles[index]);
    }
}
