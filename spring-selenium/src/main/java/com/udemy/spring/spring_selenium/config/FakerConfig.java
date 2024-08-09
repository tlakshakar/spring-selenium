package com.udemy.spring.spring_selenium.config;

import com.github.javafaker.Faker;
import com.udemy.spring.spring_selenium.custom_annotation.LazyConfiguration;
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
 * It’s a manual configuraton.
 * Used when automatic configuration is not an option (e.g., third-party libraries).
 * Annotate a method within a `@Configuration` class.
 * The method returns an object that Spring registers as a bean.
 * You define the logic for creating the instance inside the method.
 * Useful when you don't own the source code (e.g., external libraries).
 *
 * @Lazy
 *
 * Spring creates all singleton beans eagerly at the startup of the application context. Using @Lazy, you can defer the creation of a bean until it is actually needed, which can help improve the startup time of your application.
 * You can apply @Lazy to @Component and @Bean definitions.
 * It is not related to inject a bean uniquely.
 */
//@Lazy
//@Configuration
@LazyConfiguration
public class FakerConfig {
    /**
     * Inside this class, there’s a method annotated with @Bean.
     * When Spring initializes the application context, it will invoke this method and register the returned Faker object as a bean.
     *
     * @return
     */
    @Bean
    public Faker getFaker() {
        /**
         * This means that whenever you request the “faker” bean from the Spring container, it will provide this newly created Faker instance.
         */
        return new Faker(); // Create new instance of Faker
    }
}

