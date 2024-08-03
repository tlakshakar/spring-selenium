package com.udemy.spring.spring_selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RedbusAutomationSelectorPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.redbus.in");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        webDriverWait.until(driver1 -> js.executeScript("return document.readyState").equals("complete"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Enter source and destination cities
        driver.findElement(By.cssSelector("#src.sc-bxivhb")).sendKeys("Bangalore");
        driver.findElement(By.cssSelector("#src.sc-bxivhb")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("#dest.sc-bxivhb")).sendKeys("Chennai");
        driver.findElement(By.cssSelector("#dest.sc-bxivhb")).sendKeys(Keys.ENTER);

        // Click on date picker
        driver.findElement(By.cssSelector(".labelCalendarContainer")).click();
        String monthTitle = driver.findElement(By.xpath(".//div[starts-with(@class,'DatePicker__MainBlock')]" +
                "//div[starts-with(@class,'DayNavigator__CalendarHeader')]" +
                "//div[starts-with(@class,'DayNavigator__IconBlock')][contains(@style,'font-size')]")
        ).getText();
        System.out.println("Month Title: "+monthTitle);

        WebElement dayToSelect = null;
        //List<WebElement> allCalendarDays = driver.findElements(By.xpath(".//div[starts-with(@class,'DatePicker__MainBlock')]//div[starts-with(@class,'DayTilesWrapper__RowWrap')]//span//div[starts-with(@class,'DayTiles__CalendarDaysBlock')]/span[starts-with(@class,'DayTiles__CalendarDaysSpan')]"));
        List<WebElement> allDays = driver.findElements(By.xpath(".//div[starts-with(@class,'DatePicker__MainBlock')]" +
                "//div[starts-with(@class,'DayTilesWrapper__RowWrap')]" +
                "//span//div[starts-with(@class,'DayTiles__CalendarDaysBlock')]" +
                    "/span[starts-with(@class,'DayTiles__CalendarDaysSpan')]"));
        for (WebElement ee:allDays) {
            String redBackground = ee.getCssValue("background");
            if(redBackground.contains("rgb(239, 67, 72)")) {
                System.out.println("Red : " + redBackground);
                dayToSelect = ee;
                break;
            }
        }
        System.out.println("Day Default: "+dayToSelect.getText());

        //SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        Date currentDate = new Date();
        String formattedDate = sdf.format(currentDate);
        System.out.println("Formatted date: " + formattedDate);

        String inputDate = "10 Dec 2024";
        String getCurrentMonth = monthTitle.split(" ")[0];
        String getMonthFromDateToInput = inputDate.split(" ")[1];
        if(getMonthFromDateToInput.equalsIgnoreCase(getCurrentMonth)) {
            String currentDay = String.format(".//div[starts-with(@class,'DatePicker__MainBlock')]" +
                    "//div[starts-with(@class,'DayTilesWrapper__RowWrap')]" +
                    "//span//div[starts-with(@class,'DayTiles__CalendarDaysBlock')]" +
                    "/span[starts-with(@class,'DayTiles__CalendarDaysSpan')][contains(text(),%s)]", formattedDate);

            WebElement setDay = driver.findElement(By.xpath(currentDay));
            setDay.click();
        } else {
            driver.findElement(By.cssSelector(".labelCalendarContainer")).click();
            WebElement leftArrow = driver.findElement(By.xpath((".//div[starts-with(@class,'DatePicker__MainBlock')]" +
                    "//div[starts-with(@class,'DayNavigator__CalendarHeader')]" +
                    "//div[starts-with(@class,'DayNavigator__IconBlock')][contains(@style,'flex-grow')][position()=1]")));
            WebElement rightArrow = driver.findElement(By.xpath((".//div[starts-with(@class,'DatePicker__MainBlock')]" +
                    "//div[starts-with(@class,'DayNavigator__CalendarHeader')]" +
                    "//div[starts-with(@class,'DayNavigator__IconBlock')][contains(@style,'flex-grow')][position()=3]")));

            rightArrow.click();

            String day = String.format(".//div[starts-with(@class,'DatePicker__MainBlock')]" +
                    "//div[starts-with(@class,'DayTilesWrapper__RowWrap')]" +
                    "//span//div[starts-with(@class,'DayTiles__CalendarDaysBlock')]" +
                    "/span[starts-with(@class,'DayTiles__CalendarDaysSpan')][contains(text(),%s)]", inputDate.split(" ")[0]);
            driver.findElement(By.xpath(day)).click();
        }

        driver.findElement(By.id("search_button")).click();

        webDriverWait.until(driver1 -> js.executeScript("return document.readyState").equals("complete"));
        WebElement tag = driver.findElement(By.xpath(".//*[@class='h2-tag-seo']"));
        System.out.println("Tag: "+tag.getText());

        String countOfBuses = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
        System.out.println("Count of Buses: "+countOfBuses);

        // Close the browser
        driver.quit();
    }
}