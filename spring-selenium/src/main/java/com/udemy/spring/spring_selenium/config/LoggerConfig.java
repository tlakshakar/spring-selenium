package com.udemy.spring.spring_selenium.config;

import com.udemy.spring.spring_selenium.custom_annotation.LazyConfiguration;
import com.udemy.spring.spring_selenium.util.LoggingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

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
public class LoggerConfig {
    @Bean
    public LoggingService getloggingService() {
        return new LoggingService();
    }
}
