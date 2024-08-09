package com.udemy.spring.spring_selenium.custom_annotation;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Purpose of this class is wherever we will be adding annotation to any class that will be treated as main class or main page.
 */

@Lazy
@Component
@Scope("prototype")
@Documented // It indicates that elements using that annotation should be documented by tools like Javadoc. The annotation will be included in the documentation for any method it annotates.
@Target({ElementType.TYPE}) // It means that the annotation can only be applied to types, such as classes, interfaces, or enums. @Target can only be used to annotate other annotations.
@Retention(RetentionPolicy.RUNTIME) // The annotation is recorded in the compiled class file and retained by the JVM at runtime, making it accessible through reflection.
public @interface PageAnnotations {
//    String value() default "I am PageAnnotations. Can annotate a class";
}
