package com.udemy.spring.spring_selenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.time.Duration;

@Lazy // It is not related to inject a bean uniquely
@Configuration
public class WebDriverWaitConfig {
    @Value("${default.timeout:30}")
    private int timeout;

    /**
     * Spring checks that this method webDriverWait() needs webdriver instance.
     * Do I have Bean created?
     * I found chromeDriver bean, let me give it to you
     *
     * @param driver
     * @return
     */
    @Bean
    public WebDriverWait webdriverWait(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(this.timeout));
    }
}
