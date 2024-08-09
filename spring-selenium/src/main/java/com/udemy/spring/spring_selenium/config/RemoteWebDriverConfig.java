package com.udemy.spring.spring_selenium.config;

import com.udemy.spring.spring_selenium.custom_annotation.LazyConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import java.net.URL;
import java.time.Duration;

/**
 * RemoteWebDriverConfig -> This class is created to handle selenium grid where we need remote webdriver instances
 * WebDriverConfig -> This class is created to handle local webdriver instances
 */

/**
 * @Configuration
 *
 * The @Configuration annotation is used at the class level to indicate that the class is a source of bean definitions.
 * It tells Spring that this class contains methods annotated with @Bean, which define beans to be managed by the Spring container.
 * Essentially, it allows you to create beans programmatically rather than relying on XML configuration.
 *
 * @Lazy
 *
 * Spring creates all singleton beans eagerly at the startup of the application context. Using @Lazy, you can defer the creation of a bean until it is actually needed, which can help improve the startup time of your application.
 * You can apply @Lazy to @Component and @Bean definitions.
 * It is not related to inject a bean uniquely.
 */
//@Lazy // It is not related to inject a bean uniquely
//@Configuration
@LazyConfiguration
/**
 * @Profile -- This annotation allows you to conditionally activate or deactivate beans based on specific profiles.
 * Profiles are a way to segregate parts of your application configuration and make them available only in certain environments (e.g., development, testing, production).
 * You can assign profiles to beans using the @Profile annotation.
 * Let’s say you have a bean that should only be active during development but not deployed in production.
 * You can annotate that bean with the @Profile("dev") annotation.
 * It will only be present in the container during development. In production, the dev profile won’t be active.
 */
@Profile("remote")
public class RemoteWebDriverConfig {
    @Value("${selenium.grid.url}")
    private URL url;
    @Value("${default.timeout:30}")
    private int timeout;

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver remoteFirefoxDriver() {
        return new RemoteWebDriver(this.url, new FirefoxOptions());
    }

    @Bean
    @ConditionalOnMissingBean
    public WebDriver remoteChromeDriver() {
        return new RemoteWebDriver(this.url, new ChromeOptions());
    }

    /**
     * Spring checks that this method webDriverWait() needs webdriver instance.
     * Do I have bean created?
     * I found chromeDriver bean, let me give it to you
     *
     * @param driver
     * @return
     */
    // TODO: Moved to WebDriverWaitConfig during refactoring
    /*@Bean
    public WebDriverWait webDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(this.timeout));
    }*/
}
