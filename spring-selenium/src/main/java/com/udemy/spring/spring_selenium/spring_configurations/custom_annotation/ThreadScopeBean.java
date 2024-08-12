package com.udemy.spring.spring_selenium.spring_configurations.custom_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.lang.annotation.*;

@Bean
@Scope("browserscope")
@Documented // It indicates that elements using that annotation should be documented by tools like Javadoc. The annotation will be included in the documentation for any method it annotates.
@Target({ElementType.METHOD}) // It means that the annotation can be applied to methods. @Target can only be used to annotate other annotations.
@Retention(RetentionPolicy.RUNTIME) // The annotation is recorded in the compiled class file and retained by the JVM at runtime, making it accessible through reflection.
public @interface ThreadScopeBean {
//    String value() default "I am ThreadScopeBean Annotation. Can annotate a method";
}
