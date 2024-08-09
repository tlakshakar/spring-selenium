package com.udemy.spring.spring_selenium.custom_annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Lazy
@Configuration
@Documented // It indicates that elements using that annotation should be documented by tools like Javadoc. The annotation will be included in the documentation for any method it annotates.
@Target({ElementType.TYPE}) // It means that the annotation can only be applied to types, such as classes, interfaces, or enums. @Target can only be used to annotate other annotations.
@Retention(RetentionPolicy.RUNTIME) // The annotation is recorded in the compiled class file and retained by the JVM at runtime, making it accessible through reflection.
public @interface LazyConfiguration {
    String value() default "I am LazyConfiguration. Can annotate a class";
}
