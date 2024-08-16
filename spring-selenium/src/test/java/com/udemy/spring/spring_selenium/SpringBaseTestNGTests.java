package com.udemy.spring.spring_selenium;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * This is similar to SpringSeleniumApplicationTests
 * Only difference is the above one is for JUnit and SpringBaseTestNGTests is for TestNG.
 *
 * AbstractTestNGSpringContextTests - Serves as an abstract base test class that integrates
 * the Spring TestContext Framework with explicit ApplicationContext testing support in TestNG environment.
 * It provides a bridge between Spring and TestNG,
 * allowing you to use Spring features (like dependency injection and transaction management) in your TestNG tests.
 *
 * In simple terms,
 * AbstractTestNGSpringContextTests is a base class provided by Spring for writing integration tests using TestNG.
 * It helps you test your Spring application by automatically setting up the Spring context for your tests.
 * When you extend this class in your test, it ensures that the Spring application context is loaded and available for your test methods.
 * It allows you to focus on writing your tests without worrying about the setup and teardown of the Spring context.
 */
@SpringBootTest
public class SpringBaseTestNGTests extends AbstractTestNGSpringContextTests {
}
