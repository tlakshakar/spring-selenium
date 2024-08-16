package com.udemy.spring.spring_selenium.spring_configurations.config;

import com.udemy.spring.spring_selenium.spring_configurations.custom_annotation.LazyConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import java.time.Duration;

/**
 * This configuration class sets up different WebDriver instances based on the active profile and properties.
 * It ensures that the appropriate driver is used depending on the environment and configuration settings.
 *
 * I have a similar class called "WebDriverConfig" that serves the same purpose.
 * However, in that class, we’ve also implemented a custom "@ThreadScopeBean" annotation and performed some code refactoring.
 */

// TODO: Disabling this class as we have WebDriverConfig

/*@Profile("!remote")
@LazyConfiguration
public class WebDriverConfigWithoutThreadScopeBean {
    @Value("${default.timeout:30}")
    private int timeout;

    @Bean
    @Scope("prototype")
    @ConditionalOnProperty(name = "browser", havingValue = "firefox") // Will comment this line to use Spring’s ApplicationContext to manage WebDriver instances for different browsers
    public WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    @Bean
    @Scope("browserscope")
    @ConditionalOnMissingBean // Will comment this line to use Spring’s ApplicationContext to manage WebDriver instances for different browsers
    public WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @Bean
    public WebDriverWait webDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(this.timeout));
    }
}*/
