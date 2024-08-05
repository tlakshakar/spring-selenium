package com.udemy.spring.spring_selenium.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

import java.time.Duration;

/**
 * In this I have 3 beans
 * - chromeDriver
 * - firefoxDriver
 * - webDriverWait
 */
@Lazy
@Configuration
public class WebDriverConfig {
    @Value("${default.timeout:30}")
    private int timeout;


    /**
     * @ConditionalOnProperty(name = "browser", havingValue = "firefox")
     *
     * When building Spring-based applications, you often need to create beans conditionally based on configuration properties.
     * This annotation enables bean registration only if an environment property or .properties is present and has a specific value.
     *
     * @Primary
     *
     * If you have multiple beans of the same type (e.g., Car and Bike for the Vehicle type),
     * you can use @Primary to give higher preference to a specific bean.
     */
    @Bean
    //@Primary
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }


    /**
     * @ConditionalOnProperty(name = "browser", havingValue = "chrome")
     *
     * When building Spring-based applications, you often need to create beans conditionally based on configuration properties.
     * This annotation enables bean registration only if an environment property or .properties is present and has a specific value.
     *
     * @Primary
     *
     * If you have multiple beans of the same type (e.g., Car and Bike for the Vehicle type),
     * you can use @Primary to give higher preference to a specific bean.
     */
    @Bean
    @ConditionalOnMissingBean
    public WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    /**
     * Spring checks that this method needs webdriver instance. Do I have bean created?
     * I found chromeDriver bean, let me give it to you
     *
     * @param driver
     * @return
     */
    @Bean
    public WebDriverWait webDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(this.timeout));
    }
}
