package com.udemy.spring.spring_selenium.googleflight;

import org.springframework.test.context.TestPropertySource;

/**
 * Execution will happen in the default Indonesian language, because the FlightInfoProperties class has "id.properties" set by default.
 * If you want to run the test in English, you’ll need to parameterize ${app.locale} in the FlightInfoProperties class
 */
@TestPropertySource(properties = "app.locale=en")
public class EnglishTest extends FlightTest {}
