package com.udemy.spring.spring_selenium.AOP.googleFlightsTests;

import org.springframework.test.context.TestPropertySource;

/**
 * Implement Aspect Oriented Programming -- AOP Assignment
 */
@TestPropertySource(properties = {"app.locale=id", "browser=firefox"})
public class IndonesianAOPTest extends FlightAOPTest {}
