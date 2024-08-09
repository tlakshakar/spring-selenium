package com.udemy.spring.spring_selenium.scope;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * So, here’s what happens: When you add a configuration in Spring, Spring reads that configuration.
 *
 * Now, when Spring Boot starts your application, it goes through the following steps:
 *
 * Reading Configurations: It reads any configurations you’ve set up.
 * Checking Postprocessors: It encounters something called a “postprocessor.” We need to investigate this.
 * New Scope: The postprocessor seems to be experimenting with a new scope.
 * Understanding the Scope: Let’s dive into what this scope is all about.
 * Connecting the Dots: This sequence of steps shows how everything is interconnected.
 */
@Configuration
public class BrowserScopeConfig {
    /**
     * This bean returns an instance of the BrowserScopePostProcessor.
     * @return
     */
    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor(){
        return new BrowserScopePostProcessor();
    }
}
