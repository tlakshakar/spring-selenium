package com.udemy.spring.cucumberwithspringboot.spring_configurations.aspect_orient_programming;

import com.udemy.spring.cucumberwithspringboot.spring_configurations.custom_annotation.TakeScreenshotAnnotations;
import com.udemy.spring.cucumberwithspringboot.spring_configurations.util.ScreenshotService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implement Aspect Oriented Programming -- AOP Assignment
 */
@Aspect
@Service
public class ScreenshotServiceAspect {
    @Autowired
    private ScreenshotService screenshotService;

    @After("@annotation(takeScreenshot)")
    public void after(TakeScreenshotAnnotations takeScreenshot) {
        this.screenshotService.takeScreenshot();
    }
}
