package com.udemy.spring.spring_selenium.WebDriverFactory;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTests;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

/**
 * This code demonstrates how to use Spring’s ApplicationContext to manage WebDriver instances for different browsers (Chrome and Firefox) and perform basic browser automation tasks within a TestNG test case.
 * This code will only work if all conditions are disabled defined under WebDriverConfig.java file
 * When I say conditions, it means below
 * - @ConditionalOnProperty(name = "browser", havingValue = "firefox")
 * - @ConditionalOnMissingBean
 */
public class WebDriverFactoryViaApplicationContext extends SpringBaseTestNGTests {
    @Autowired
    private ApplicationContext ctx;

    @Test
    @Ignore // TODO: Remove this if you want this test to be working
    public void browserTest() {
        this.ctx.getBean("chromeDriver", WebDriver.class).get("https://www.google.com/"); // retrieves a bean named chromeDriver of type WebDriver from the application context and opens the URL in the Chrome browser.
        this.ctx.getBean("chromeDriver", WebDriver.class).quit();
        this.ctx.getBean("firefoxDriver", WebDriver.class).get("https://www.wikipedia.org/");
        this.ctx.getBean("firefoxDriver", WebDriver.class).quit();
    }
}
