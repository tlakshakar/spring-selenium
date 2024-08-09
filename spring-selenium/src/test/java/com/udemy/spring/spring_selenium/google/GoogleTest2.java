package com.udemy.spring.spring_selenium.google;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTests;
import com.udemy.spring.spring_selenium.config.LoggerConfig;
import com.udemy.spring.spring_selenium.page.google.GooglePage;
import com.udemy.spring.spring_selenium.util.ScreenshotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class GoogleTest2 extends SpringBaseTestNGTests {
    @Lazy
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
        try {
            this.loggerConfig.getloggingService().logMessage("..............................................");
            this.loggerConfig.getloggingService().logMessage("Running Test: "+method.getName());
            this.googlePage.goTo();
            this.loggerConfig.getloggingService().logMessage("Navigating to \""+this.googlePage.getUrl()+"\" web page");
            Assert.assertTrue(this.googlePage.isAt());
            this.loggerConfig.getloggingService().logMessage("Search bar of google page is loaded");
            this.loggerConfig.getloggingService().logMessage("Getting the title of browser");
            Assert.assertEquals(this.googlePage.getGooglePageTitle(), "Google");
            this.loggerConfig.getloggingService().logMessage("Quitting/Closing the browser");
            this.googlePage.close();
            this.loggerConfig.getloggingService().logMessage("..............................................");
        } catch (Exception e) {
            System.out.println("Running Test: "+method.getName());
            System.out.println("Session ID is null. Please ensure WebDriver is properly initialized.");
            System.out.println(e.getMessage());
        }
    }}
