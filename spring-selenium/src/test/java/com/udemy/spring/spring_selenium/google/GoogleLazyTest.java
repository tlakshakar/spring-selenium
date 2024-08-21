package com.udemy.spring.spring_selenium.google;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTests;
import com.udemy.spring.spring_selenium.page.google.GooglePage;
import com.udemy.spring.spring_selenium.spring_configurations.custom_annotation.LazyAutowired;
import com.udemy.spring.spring_selenium.spring_configurations.util.CommonUtil;
import com.udemy.spring.spring_selenium.spring_configurations.util.ScreenshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

/**
 * In the provided GoogleLazyTest class, the browser will not open because the code that would trigger the browser to open is commented out.
 * The @Lazy annotation in combination with @Autowired is used to delay the initialization of a bean until it is actually needed.
 */
public class GoogleLazyTest extends SpringBaseTestNGTests {
    //@Lazy // When applied to a bean, it indicates that the bean should not be initialized until it is first requested.
    //@Autowired // Tells Spring to automatically wire the specified bean into the field.
    @LazyAutowired
    private GooglePage googlePage;
    @LazyAutowired
    private ScreenshotService screenShotUtil;

    @BeforeSuite
    public void setup() {
        CommonUtil.deleteAllImages();
    }

    @Test
    @Ignore // TODO: Remove @Ignore if you want this test to be working
    public void googleLazyTest() {
        /*this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        this.screenShotUtil.takeScreenshot("GOOGLE_LAZY_TEST");
        this.googlePage.close();*/
    }
}
