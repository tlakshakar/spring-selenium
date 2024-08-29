package com.udemy.spring.spring_selenium.spring_configurations.config;

import com.udemy.spring.spring_selenium.spring_configurations.custom_annotation.LazyConfiguration;
import com.udemy.spring.spring_selenium.spring_configurations.util.LoggingService;
import org.springframework.context.annotation.Bean;

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
    /**
     * Inside this class, there’s a method annotated with @Bean.
     * When Spring initializes the application context, it will invoke this method and register the returned LoggingService object as a bean.
     *
     * @return
     */
    @Bean
    public LoggingService getloggingService() {
        /**
         * This means that whenever you request the “loggingService” bean from the Spring container, it will provide this newly created LoggingService instance.
         */
        return new LoggingService();
    }
}
