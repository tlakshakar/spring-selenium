package com.udemy.spring.spring_selenium.spring_configurations.aspect_orient_programming;

import com.udemy.spring.spring_selenium.spring_configurations.custom_annotation.Loggable;
import com.udemy.spring.spring_selenium.spring_configurations.util.LoggingService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Create custom annotation of logging service in spring boot
// TODO Reference: https://docs.spring.io/spring-framework/docs/2.0.x/reference/aop.html
@Aspect
@Component
public class LoggingAspect {
    @Autowired
    private LoggingService loggingService;

    @Pointcut("execution(* com.udemy.spring.spring_selenium.page.googleflights.page.*.*(..))")
    public void loggableMethods() {}

    @Before("@annotation(loggable)")
    public void logBefore(Loggable loggable) {
        this.loggingService.logMessage("Logging before " + loggable.value());
    }

    /**
     * We’ve just recorded the current time, executed the method, then printed the amount of time it took to the console.
     * We’re also logging the method signature, which is provided to use the joinpoint instance.
     *
     * The first parameter of the advice method must be of type ProceedingJoinPoint. Within the body of the advice, calling proceed() on the ProceedingJoinPoint causes the underlying method to execute
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "loggableMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        // Log execution time or perform other logging actions
        this.loggingService.logMessage(joinPoint.getSignature().toShortString() + " executed in " + executionTime + "ms");
        return result;
    }

    @AfterReturning(pointcut = "loggableMethods()", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        this.loggingService.logMessage("Logging after " + joinPoint.getSignature().toShortString() + ". Result: " + result);
    }
}
