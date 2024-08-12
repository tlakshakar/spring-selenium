package com.udemy.spring.spring_selenium.google;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTests;
import com.udemy.spring.spring_selenium.spring_configurations.config.LoggerConfig;
import com.udemy.spring.spring_selenium.page.google.GooglePage;
import com.udemy.spring.spring_selenium.spring_configurations.custom_annotation.LazyAutowired;
import com.udemy.spring.spring_selenium.spring_configurations.util.CommonUtil;
import com.udemy.spring.spring_selenium.spring_configurations.util.ScreenshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class GoogleTest4 extends SpringBaseTestNGTests {
//    @Lazy
//    @Autowired
    @LazyAutowired
    private GooglePage googlePage;

//    @Lazy
//    @Autowired
    @LazyAutowired
    private ScreenshotService screenShotUtil;

//    @Lazy
//    @Autowired
    @LazyAutowired
    private LoggerConfig loggerConfig;

    @BeforeSuite
    public void setup() {
        CommonUtil.deleteAllImages();
    }

    @Test
    public void googleTest41(Method method) {
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
            this.googlePage.getSearchComponent().search("docker");
            this.loggerConfig.getloggingService().logMessage("Searching a text docker");
            Assert.assertTrue(this.googlePage.getSearchResultComponent().isAt());
            this.loggerConfig.getloggingService().logMessage("Search page is loaded with all findings");
            Assert.assertTrue(this.googlePage.getSearchResultComponent().getCount() > 2);
            this.loggerConfig.getloggingService().logMessage("Asserting that count of searched text > 2");
            this.loggerConfig.getloggingService().logMessage("Capturing screenshot");
            this.screenShotUtil.takeScreenshot("GOOGLE41");
            //this.googlePage.close();
            this.loggerConfig.getloggingService().logMessage("..............................................");
        } catch (Exception e) {
            System.out.println("----------------------------------------------------------------");
            e.printStackTrace();
            System.out.println("----------------------------------------------------------------");
        }
    }

    @Test
    public void googleTest42(Method method) {
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
            this.googlePage.getSearchComponent().search("Kubernetes");
            this.loggerConfig.getloggingService().logMessage("Searching a text Kubernetes");
            Assert.assertTrue(this.googlePage.getSearchResultComponent().isAt());
            this.loggerConfig.getloggingService().logMessage("Search page is loaded with all findings");
            Assert.assertTrue(this.googlePage.getSearchResultComponent().getCount() > 2);
            this.loggerConfig.getloggingService().logMessage("Asserting that count of searched text > 2");
            this.loggerConfig.getloggingService().logMessage("Capturing screenshot");
            this.screenShotUtil.takeScreenshot("GOOGLE42");
            this.googlePage.close();
            this.loggerConfig.getloggingService().logMessage("..............................................");
        } catch (Exception e) {
            System.out.println("----------------------------------------------------------------");
            e.printStackTrace();
            System.out.println("----------------------------------------------------------------");
        }
    }
}
