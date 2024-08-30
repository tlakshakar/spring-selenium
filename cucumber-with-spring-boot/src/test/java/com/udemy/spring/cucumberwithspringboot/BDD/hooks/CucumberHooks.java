package com.udemy.spring.cucumberwithspringboot.BDD.hooks;

import com.udemy.spring.cucumberwithspringboot.spring_configurations.custom_annotation.LazyAutowired;
import com.udemy.spring.cucumberwithspringboot.spring_configurations.util.ScreenshotService;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

public class CucumberHooks {
    @LazyAutowired
    private ScreenshotService screenshotService;

    @LazyAutowired
    private ApplicationContext context;

    @AfterStep
    public void captureScreenshot(Scenario scenario) {
        if(scenario.isFailed()) {
            scenario.attach(this.screenshotService.getScreenshot(), "image/png", scenario.getName());
        }
    }

    @After
    public void closeBrowser() {
        this.context.getBean(WebDriver.class).quit();
    }
}
