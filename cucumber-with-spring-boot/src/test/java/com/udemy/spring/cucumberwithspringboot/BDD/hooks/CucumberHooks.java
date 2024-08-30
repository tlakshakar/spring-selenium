package com.udemy.spring.cucumberwithspringboot.BDD.hooks;

import com.udemy.spring.cucumberwithspringboot.spring_configurations.custom_annotation.LazyAutowired;
import com.udemy.spring.cucumberwithspringboot.spring_configurations.util.ScreenshotService;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class CucumberHooks {
    @LazyAutowired
    private ScreenshotService screenshotService;

    @AfterStep
    public void captureScreenshot(Scenario scenario) {
        if(scenario.isFailed()) {
            scenario.attach(this.screenshotService.getScreenshot(), "image/png", scenario.getName());
        }
    }

    @After
    public void closeBrowser() {

    }
}
