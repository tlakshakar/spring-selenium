package com.udemy.spring.spring_selenium.redbus;

import com.udemy.spring.spring_selenium.page.redbus.RedBusPage;
import com.udemy.spring.spring_selenium.SpringBaseTestNGTests;
import com.udemy.spring.spring_selenium.spring_configurations.custom_annotation.LazyAutowired;
import com.udemy.spring.spring_selenium.spring_configurations.util.CommonUtil;
import com.udemy.spring.spring_selenium.spring_configurations.util.ScreenshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class RedBusTest extends SpringBaseTestNGTests {
//    @Lazy
//    @Autowired
    @LazyAutowired
    private RedBusPage redBusPage;

//    @Lazy
//    @Autowired
    @LazyAutowired
    private ScreenshotService screenshotUtil;

    @BeforeSuite
    public void setup() {
        CommonUtil.deleteAllImages();
    }

    @Test
    public void redbusTest1(Method method) {
        System.out.println("Running Test: " + method.getName() + "..................");
        try {
            this.redBusPage.goTo();
            this.redBusPage.maximizeWindow();
            this.redBusPage.delay(3000); // debugging purpose
            Assert.assertTrue(this.redBusPage.isAt());

            this.redBusPage.getSearchBus().searchBusForToday("Bangalore", "Chennai");
            this.screenshotUtil.takeScreenshot("BangaloreToChennai.png");
            this.redBusPage.getSearchBus().clickSearchBusesButton();
            Assert.assertTrue(this.redBusPage.getSearchResults().isAt());

            String busheaderTag = this.redBusPage.getSearchResults().getBusHeaderTag();
            System.out.println("Bus Header Tag: " + busheaderTag);
            String countOfBuses = this.redBusPage.getSearchResults().getCountOfBuses();
            System.out.println("Count of Buses: " + countOfBuses);
            int countOfBus = Integer.parseInt(countOfBuses.split(" ")[0]);
            Assert.assertTrue(countOfBus > 0);

            this.screenshotUtil.takeScreenshot();
            this.redBusPage.close();
        } catch (Exception e) {
            System.out.println("----------------------------------------------------------------");
            e.printStackTrace();
            System.out.println("----------------------------------------------------------------");
        }
    }

    /**
     * Spring bean quits webdriver instance after running 1 test.
     * <p>
     * It seems that Spring Boot Selenium app is causing the WebDriver to quit after each test.
     * When using @Autowired page objects, there’s no straightforward way to prevent WebDriver from quitting after each test.
     * <p>
     * This problem can be resolved with @Scope annotation -- Custom ThreadScope
     */
    @Test
    public void redbusTest2(Method method) {
        System.out.println("Running Test: " + method.getName() + "..................");
        try {
            this.redBusPage.goTo();
            this.redBusPage.maximizeWindow();
            this.redBusPage.delay(3000); // debugging purpose
            Assert.assertTrue(this.redBusPage.isAt());

            this.redBusPage.getSearchBus().searchBusForParticularDay("Chennai", "Bangalore", CommonUtil.getRandomDateWithinNextTwoMonths());
            this.screenshotUtil.takeScreenshot("ChennaiToBangalore.png");
            this.redBusPage.getSearchBus().clickSearchBusesButton();
            Assert.assertTrue(this.redBusPage.getSearchResults().isAt());

            String busheaderTag = this.redBusPage.getSearchResults().getBusHeaderTag();
            System.out.println("Bus Header Tag: " + busheaderTag);
            String countOfBuses = this.redBusPage.getSearchResults().getCountOfBuses();
            System.out.println("Count of Buses: " + countOfBuses);
            int countOfBus = Integer.parseInt(countOfBuses.split(" ")[0]);
            Assert.assertTrue(countOfBus > 0);

            this.screenshotUtil.takeScreenshot();
            this.redBusPage.close();
        } catch (Exception e) {
            System.out.println("----------------------------------------------------------------");
            e.printStackTrace();
            System.out.println("----------------------------------------------------------------");
        }
    }

    /**
     * Spring bean quits webdriver instance after running 1 test.
     * <p>
     * It seems that Spring Boot Selenium app is causing the WebDriver to quit after each test.
     * When using @Autowired page objects, there’s no straightforward way to prevent WebDriver from quitting after each test.
     * <p>
     * This problem can be resolved with @Scope annotation -- Custom ThreadScope
     */
    @Test
    public void redbusTest3(Method method) {
        System.out.println("Running Test: " + method.getName() + "..................");
        try {
            this.redBusPage.goTo();
            this.redBusPage.maximizeWindow();
            this.redBusPage.delay(3000); // debugging purpose
            Assert.assertTrue(this.redBusPage.isAt());

            this.redBusPage.getSearchBus().searchBusForParticularDay("Pune", "Mumbai", CommonUtil.getRandomDateWithinNextTwoMonths());
            this.screenshotUtil.takeScreenshot("PuneToMumbai.png");
            this.redBusPage.getSearchBus().clickSearchBusesButton();
            Assert.assertTrue(this.redBusPage.getSearchResults().isAt());

            String busheaderTag = this.redBusPage.getSearchResults().getBusHeaderTag();
            System.out.println("Bus Header Tag: " + busheaderTag);
            String countOfBuses = this.redBusPage.getSearchResults().getCountOfBuses();
            System.out.println("Count of Buses: " + countOfBuses);
            int countOfBus = Integer.parseInt(countOfBuses.split(" ")[0]);
            Assert.assertTrue(countOfBus > 0);

            this.screenshotUtil.takeScreenshot();
            this.redBusPage.close();
        } catch (Exception e) {
            System.out.println("----------------------------------------------------------------");
            e.printStackTrace();
            System.out.println("----------------------------------------------------------------");
        }
    }
}