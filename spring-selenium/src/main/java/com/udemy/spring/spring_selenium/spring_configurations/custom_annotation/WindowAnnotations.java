package com.udemy.spring.spring_selenium.spring_configurations.custom_annotation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * AOP -- Aspect Oriented Programming
 */
@PageAnnotations
@Documented // It indicates that elements using that annotation should be documented by tools like Javadoc. The annotation will be included in the documentation for any method it annotates.
@Target({ElementType.TYPE}) // It means that the annotation can only be applied to types, such as classes, interfaces, or enums. @Target can only be used to annotate other annotations.
@Retention(RetentionPolicy.RUNTIME) // The annotation is recorded in the compiled class file and retained by the JVM at runtime, making it accessible through reflection.
public @interface WindowAnnotations {
//    String value() default "I am WindowAnnotations for each window. Can annotate a class";
    String value() default "";
}
