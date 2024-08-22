package com.udemy.spring.spring_selenium.spring_configurations.custom_annotation;

import java.lang.annotation.*;

/**
 * Implement Aspect Oriented Programming -- AOP Assignment
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Loggable {
    String value() default "";
}