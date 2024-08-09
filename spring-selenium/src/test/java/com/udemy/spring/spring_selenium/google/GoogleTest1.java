package com.udemy.spring.spring_selenium.google;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTests;
import com.udemy.spring.spring_selenium.config.LoggerConfig;
import com.udemy.spring.spring_selenium.page.google.GooglePage;
import com.udemy.spring.spring_selenium.util.CommonUtil;
import com.udemy.spring.spring_selenium.util.ScreenshotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class GoogleTest1 extends SpringBaseTestNGTests {
    @Lazy
    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    private ScreenshotUtil screenShotUtil;

    @Lazy
    @Autowired
    private LoggerConfig loggerConfig;

    @BeforeSuite
    public void setup() {
        CommonUtil.deleteAllImages();
    }

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
            this.loggerConfig.getloggingService().logMessage("Capturing screenshot");
            this.screenShotUtil.takeScreenshot("GOOGLE11.png");
            this.googlePage.close();
            this.loggerConfig.getloggingService().logMessage("..............................................");
        } catch (Exception e) {
            System.out.println("Running Test: "+method.getName());
            System.out.println("Session ID is null. Please ensure WebDriver is properly initialized.");
            System.out.println("----------------------------------------------------------------");
            e.printStackTrace();
            System.out.println("----------------------------------------------------------------");
            // Fail the test if an exception occurs
            Assert.fail(method.getName()+" test failed due to exception: " + e.getMessage());
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
            this.loggerConfig.getloggingService().logMessage("Capturing screenshot");
            this.screenShotUtil.takeScreenshot("GOOGLE12.png");
            //this.googlePage.close();
            this.loggerConfig.getloggingService().logMessage("..............................................");
        } catch (Exception e) {
            System.out.println("Running Test: "+method.getName());
            System.out.println("Session ID is null. Please ensure WebDriver is properly initialized.");
            System.out.println("----------------------------------------------------------------");
            e.printStackTrace();
            System.out.println("----------------------------------------------------------------");
            // Fail the test if an exception occurs
            Assert.fail(method.getName()+" test failed due to exception: " + e.getMessage());
        }
    }
}
