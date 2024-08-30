package com.udemy.spring.cucumberwithspringboot.BDD.configuration;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * The SpringIntegrationTest class combines Cucumber with Spring Boot, leveraging dependency injection and ensuring that your Cucumber steps can interact with the Spring context.
 *
 * @CucumberContextConfiguration - This annotation is used to integrate Cucumber tests with the Spring Application Context.
 * It allows you to configure the context for your Cucumber tests.
 *
 * @SpringBootTest - This annotation is commonly used in Spring Boot integration tests.
 * It loads the complete Spring application context and provides a way to test your application end-to-end.
 * When combined with Cucumber, it ensures that your Cucumber steps have access to the Spring context.
 */
@CucumberContextConfiguration
@SpringBootTest
public class SpringIntegrationTest {

}