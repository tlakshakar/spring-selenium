package com.udemy.spring.spring_selenium.googleflight;

import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = {"app.locale=id", "browser=firefox"})
public class IndonesianTest extends FlightTest {}
