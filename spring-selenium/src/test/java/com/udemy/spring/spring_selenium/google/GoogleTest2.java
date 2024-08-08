package com.udemy.spring.spring_selenium.google;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTests;
import com.udemy.spring.spring_selenium.config.LoggerConfig;
import com.udemy.spring.spring_selenium.page.google.GooglePage;
import com.udemy.spring.spring_selenium.util.ScreenshotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class GoogleTest2 extends SpringBaseTestNGTests {
    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    private ScreenshotUtil screenShotUtil;

    @Lazy
    @Autowired
    private LoggerConfig loggerConfig;

    @Test
    public void googleTest21(Method method) throws IOException {
        this.loggerConfig.getloggingService().logMessage("..............................................");
        this.loggerConfig.getloggingService().logMessage("Running Test: "+method.getName());
        this.googlePage.goTo();
        this.loggerConfig.getloggingService().logMessage("Navigating to \""+this.googlePage.getUrl()+"\" web page");
        Assert.assertTrue(this.googlePage.isAt());
        this.loggerConfig.getloggingService().logMessage("Search bar of google page is loaded");
        this.loggerConfig.getloggingService().logMessage("Getting the title of browser");
        Assert.assertEquals(this.googlePage.getGooglePageTitle(), "Google");
        this.loggerConfig.getloggingService().logMessage("..............................................");
    }}
