package com.udemy.spring.spring_selenium.AOP.googleFlightsTests;

import org.springframework.test.context.TestPropertySource;

/**
 * Implement Aspect Oriented Programming -- AOP Assignment
 *
 * Execution will happen in the default Indonesian language (id), because the FlightInfoProperties class has "id.properties" set by default.
 * If you want to run the test in English, you’ll need to parameterize ${app.locale} in the FlightInfoProperties class
 */
@TestPropertySource(properties = "app.locale=en")
public class EnglishAOPTest extends FlightAOPTest {}
