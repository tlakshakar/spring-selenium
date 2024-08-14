package com.udemy.spring.spring_selenium.googleflight;

import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = "app.locale=en")
public class EnglishTest extends FlightTest {}
