package com.udemy.spring.spring_selenium.spring_configurations.config;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * This code demonstrates how to use Spring’s ApplicationContext to manage WebDriver instances for different browsers (Chrome and Firefox) and perform basic browser automation tasks within a TestNG test case.
 * This code will only work if all conditions are disabled defined under WebDriverConfig.java file
 * When I say conditions, it means below
 * - @ConditionalOnProperty(name = "browser", havingValue = "firefox")
 * - @ConditionalOnMissingBean
 */
@Component
public class WebDriverFactory {
    @Autowired
    private ApplicationContext ctx;
    public WebDriver getWebDriver(String browser) {
        if ("chrome".equalsIgnoreCase(browser)) {
            return ctx.getBean("chromeDriver", WebDriver.class);
        } else if ("firefox".equalsIgnoreCase(browser)) {
            return ctx.getBean("firefoxDriver", WebDriver.class);
        }
        throw new IllegalArgumentException("No such browser: " + browser);
    }
}
