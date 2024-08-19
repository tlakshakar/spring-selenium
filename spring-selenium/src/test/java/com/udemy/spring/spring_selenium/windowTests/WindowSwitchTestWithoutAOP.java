package com.udemy.spring.spring_selenium.windowTests;

import com.github.javafaker.Faker;
import com.udemy.spring.spring_selenium.SpringBaseTestNGTests;
import com.udemy.spring.spring_selenium.page.window.MainPage;
import com.udemy.spring.spring_selenium.page.window.PageA;
import com.udemy.spring.spring_selenium.page.window.PageB;
import com.udemy.spring.spring_selenium.spring_configurations.util.WindowSwitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.*;

@TestPropertySource(properties = "browser=firefox")
public class WindowSwitchTestWithoutAOP extends SpringBaseTestNGTests {
    @Autowired
    private MainPage mainPage;
    @Autowired
    private PageA pageA;
    @Autowired
    private PageB pageB;
    @Autowired
    private WindowSwitchService windowSwitchService;
    @Autowired
    private Faker faker; // It is a bean
    //Faker faker = new Faker(); // No need as we already created FakerConfig to allow Spring to manage it

    @BeforeSuite
    public void beforeSuite() {
        /**
         * None of objects defined will be available if we try to access them inside before suite
         * At this point they would not have been injected by Spring
         */
    }
    @BeforeTest
    public void beforeText() {
        /**
         * None of objects defined will be available if we try to access them inside before test
         * At this point they would not have been injected by Spring
         */
    }

    @BeforeClass
    public void setup() {
        this.mainPage.goTo();
        this.mainPage.isAt();
        this.mainPage.launchAllWindows();
    }

    @Test
    public void switchWindowTest() {
        this.windowSwitchService.switchWindowByTitle("Page A");
        this.pageA.enterPageAInfo(
                this.faker.name().firstName(),
                this.faker.name().lastName(),
                this.faker.address().fullAddress(),
                "Hi! Page A"
        );
        this.windowSwitchService.switchWindowByIndex(2);
        this.pageB.enterPageBInfo(
                this.faker.name().firstName(),
                this.faker.name().lastName(),
                this.faker.address().fullAddress(),
                "Hello! Page B"
        );
    }
}
