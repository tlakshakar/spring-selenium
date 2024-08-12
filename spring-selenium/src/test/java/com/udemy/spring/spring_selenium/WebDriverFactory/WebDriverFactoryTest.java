package com.udemy.spring.spring_selenium.WebDriverFactory;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTests;
import com.udemy.spring.spring_selenium.spring_configurations.config.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

/**
 * This code demonstrates how to use Spring’s ApplicationContext to manage WebDriver instances for different browsers (Chrome and Firefox) and perform basic browser automation tasks within a TestNG test case.
 * This code will only work if all conditions are disabled defined under WebDriverConfig.java file
 * When I say conditions, it means below
 * - @ConditionalOnProperty(name = "browser", havingValue = "firefox")
 * - @ConditionalOnMissingBean
 */
public class WebDriverFactoryTest extends SpringBaseTestNGTests {
    private WebDriver chromeDriver, firefoxDriver;

    @Autowired
    private WebDriverFactory webDriverFactory;

    @Test
    @Ignore // TODO: Remove this if you want this test to be working
    public void browserTest() {
        chromeDriver = webDriverFactory.getWebDriver("chrome");
        chromeDriver.get("https://www.google.com/");

        firefoxDriver = webDriverFactory.getWebDriver("firefox");
        firefoxDriver.get("https://www.wikipedia.org/");
    }

    @AfterTest
    public void tearDown() {
        chromeDriver.quit();
        firefoxDriver.quit();
    }
}
