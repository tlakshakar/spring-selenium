package com.udemy.spring.spring_selenium.spring_configurations.aspect_orient_programming;

import com.udemy.spring.spring_selenium.spring_configurations.custom_annotation.WindowAnnotations;
import com.udemy.spring.spring_selenium.spring_configurations.util.WindowSwitchService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Aspect-Oriented Programming (AOP)
 *
 * AOP complements Object-Oriented Programming (OOP) by providing another way of thinking about program structure.
 * In OOP, the key unit of modularity is the class, whereas in AOP, it’s the aspect1.
 * Aspects represent cross-cutting concerns that affect multiple parts of the application (e.g., logging, security, or transaction management).
 *
 * Below code performs actions before and after specific join points (methods) based on pointcut expressions.
 */
@Aspect
@Service // Same as @Component
public class WindowAspect {
    @Autowired
    private WindowSwitchService switchService;

    /**
     * @Before Executed before the method call
     * @target(window) && within(com.udemy.spring.spring_selenium..*) -- pointcut expression
     * This advice applies to methods within the package com.udemy.spring.spring_selenium that have the @WindowAnnotations annotation.
     *
     * @param window
     */
    @Before("@target(window) && within(com.udemy.spring.spring_selenium..*)") // Before Advice or Action taken by an aspect at a specific joinpoint before.
    public void before(WindowAnnotations window){
        System.out.println(".............I WILL EXECUTE BEFORE EACH AND EVERY METHOD.............");
        System.out.println(window.value()+" - Before() -- Any class that has WindowAnnotations. I will be triggered first.");
        System.out.println("This means that any of method in the class that has WindowAnnotations is going to be executed, before that this method would be triggered automatically");
        this.switchService.switchWindowByTitle(window.value()); // Here, window.value() will be Page A,Page B,Page C
    }

    /**
     * @After Executed after the method call, regardless of its outcome
     * The pointcut expression "@target(window) && within(com.udemy.spring.spring_selenium..*)" specifies that this advice applies to methods within the package com.udemy.spring.spring_selenium that have the @WindowAnnotations annotation.
     *
     * @param window
     */
    @After("@target(window) && within(com.udemy.spring.spring_selenium..*)") // After Advice or Action taken by an aspect at a specific joinpoint after.
    public void after(WindowAnnotations window){
        System.out.println(window.value()+" - After() -- Any class that has WindowAnnotation. I will be triggered.");
        System.out.println("This implies that any method within the class annotated with WindowAnnotations will execute, and subsequently, this method will be automatically triggered.");
        this.switchService.switchWindowByIndex(0); // Going back to main window/page
        System.out.println(".............I WILL EXECUTE AFTER EACH AND EVERY METHOD.............");
    }

    /**
     * @Around - It has the opportunity to do work both before and after the method executes,
     * and to determine when, how, and even if, the method actually gets to execute at all.
     * The @Around advice is designed to wrap the execution of a method, allowing you to control its behavior before and after execution
     *
     * TODO Reference: https://jstobigdata.com/spring/around-advice-in-spring-aop-around/
     */
    @Around("@target(com.udemy.spring.spring_selenium.spring_configurations.custom_annotation.WindowAnnotations) && within(com.udemy.spring.spring_selenium..*)")
    public Object logExecTime(ProceedingJoinPoint jp) {
        System.out.println("Before method: " + jp.getSignature().toShortString());
        long beforeTime = System.currentTimeMillis();
        Object result = null;
        try {
            result = jp.proceed(); // Important
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long afterTime = System.currentTimeMillis();
        System.out.println("After method: " + jp.getSignature().toShortString());
        System.out.println("Time taken to execute: " + (afterTime - beforeTime) + "ms\n");
        return result;
    }
}