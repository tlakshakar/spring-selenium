package com.udemy.spring.cucumberwithspringboot.spring_configurations.aspect_orient_programming;

import com.udemy.spring.cucumberwithspringboot.spring_configurations.custom_annotation.TakeScreenshotAnnotations;
import com.udemy.spring.cucumberwithspringboot.spring_configurations.util.LoggingService;
import com.udemy.spring.cucumberwithspringboot.spring_configurations.util.ScreenshotService;
import io.cucumber.java.Scenario;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implement Aspect Oriented Programming -- AOP
 * FIXME: ScreenshotServiceAspect not working at the moment.
 */
@Aspect
@Service
public class ScreenshotServiceAspect {
    @Autowired
    private ScreenshotService screenshotService;
    @Autowired
    private LoggingService loggingService;

    @Pointcut("execution(* com.udemy.spring.cucumberwithspringboot.page.googleflights.page.*.*(..))")
    //@Pointcut("within(com.udemy.spring.cucumberwithspringboot.page.googleflights.page..*)")
    public void allMethodsInPackage() {}

    @After("allMethodsInPackage() && args(scenario)")
    public void after(Scenario scenario) {
        this.loggingService.logMessage("ScreenshotServiceAspect triggered for scenario: " + scenario.getName());
        scenario.attach(this.screenshotService.getScreenshot(), "image/png", scenario.getName());
    }
}
