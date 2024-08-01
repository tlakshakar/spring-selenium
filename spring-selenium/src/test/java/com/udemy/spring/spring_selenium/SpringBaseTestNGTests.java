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
 */
@SpringBootTest
public class SpringBaseTestNGTests extends AbstractTestNGSpringContextTests {
}
