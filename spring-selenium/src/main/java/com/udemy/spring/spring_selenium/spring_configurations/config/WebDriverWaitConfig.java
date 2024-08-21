package com.udemy.spring.spring_selenium.spring_configurations.config;

import com.udemy.spring.spring_selenium.spring_configurations.custom_annotation.LazyConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.time.Duration;

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
public class WebDriverWaitConfig {
    @Value("${default.timeout:30}")
    private int timeout;

    /**
     * Spring checks that this method webDriverWait() needs webdriver instance.
     * Do I have Bean created?
     * I found chromeDriver bean, let me give it to you.
     *
     *
     * Here, default scope = Singleton
     *
     * @param driver
     * @return
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // We cannot use @ThreadScopeBean here as it is tightly coupled with WebDriver. Also, there is no way to check if this WebDriverWait is really usable or not as we did while creating BrowserScope.
    public WebDriverWait webdriverWait(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(this.timeout));
    }
}
