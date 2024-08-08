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

public class GoogleTest1 extends SpringBaseTestNGTests {
    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    private ScreenshotUtil screenShotUtil;

    @Lazy
    @Autowired
    private LoggerConfig loggerConfig;

    @Test
    public void googleTest11(Method method) {
        try {
            this.loggerConfig.getloggingService().logMessage("..............................................");
            this.loggerConfig.getloggingService().logMessage("Running Test: "+method.getName());
            this.googlePage.goTo();
            this.loggerConfig.getloggingService().logMessage("Navigating to \""+this.googlePage.getUrl()+"\" web page");
            Assert.assertTrue(this.googlePage.isAt());
            this.loggerConfig.getloggingService().logMessage("Search bar of google page is loaded");
            this.loggerConfig.getloggingService().logMessage("Getting the title of browser");
            Assert.assertEquals(this.googlePage.getGooglePageTitle(), "Google");
            this.googlePage.getSearchComponent().clearSearchBox();
            this.googlePage.delay(1000); // debugging
            this.loggerConfig.getloggingService().logMessage("Delaying the process for debugging purpose");
            this.googlePage.getSearchComponent().search("environment");
            this.loggerConfig.getloggingService().logMessage("Searching a text environment");
            Assert.assertTrue(this.googlePage.getSearchResultComponent().isAt());
            this.loggerConfig.getloggingService().logMessage("Search page is loaded with all findings");
            Assert.assertTrue(this.googlePage.getSearchResultComponent().getCount() > 2);
            this.loggerConfig.getloggingService().logMessage("Asserting that count of searched text > 2");
            this.screenShotUtil.takeScreenshot("GOOGLE11.png");
            this.loggerConfig.getloggingService().logMessage("Capturing screenshot");
            this.loggerConfig.getloggingService().logMessage("..............................................");
        } catch (Exception e) {
            System.out.println("Running Test: "+method.getName());
            System.out.println("Session ID is null. Please ensure WebDriver is properly initialized.");
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void googleTest12(Method method) {
        try {
            this.loggerConfig.getloggingService().logMessage("..............................................");
            this.loggerConfig.getloggingService().logMessage("Running Test: "+method.getName());
            this.googlePage.goTo();
            this.loggerConfig.getloggingService().logMessage("Navigating to \""+this.googlePage.getUrl()+"\" web page");
            Assert.assertTrue(this.googlePage.isAt());
            this.loggerConfig.getloggingService().logMessage("Search bar of google page is loaded");
            this.loggerConfig.getloggingService().logMessage("Getting the title of browser");
            Assert.assertEquals(this.googlePage.getGooglePageTitle(), "Google");
            this.googlePage.getSearchComponent().clearSearchBox();
            this.googlePage.delay(1000); // debugging
            this.loggerConfig.getloggingService().logMessage("Delaying the process for debugging purpose");
            this.googlePage.getSearchComponent().search("Selenium WebDriver");
            this.loggerConfig.getloggingService().logMessage("Searching a text Selenium WebDriver");
            Assert.assertTrue(this.googlePage.getSearchResultComponent().isAt());
            this.loggerConfig.getloggingService().logMessage("Search page is loaded with all findings");
            Assert.assertTrue(this.googlePage.getSearchResultComponent().getCount() > 2);
            this.loggerConfig.getloggingService().logMessage("Asserting that count of searched text > 2");
            this.screenShotUtil.takeScreenshot("GOOGLE12.png");
            this.loggerConfig.getloggingService().logMessage("Capturing screenshot");
            this.loggerConfig.getloggingService().logMessage("..............................................");
        } catch (Exception e) {
            System.out.println("Running Test: "+method.getName());
            System.out.println("Session ID is null. Please ensure WebDriver is properly initialized.");
            System.out.println(e.getMessage());
        }
    }
}
