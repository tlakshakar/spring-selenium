package com.udemy.spring.cucumberwithspringboot.spring_configurations.custom_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.lang.annotation.*;

/**
 * The @Lazy annotation in combination with @Autowired is used to delay the initialization of a bean until it is actually needed.
 */
@Lazy // When applied to a bean, it indicates that the bean should not be initialized until it is first requested.
@Autowired // Tells Spring to automatically wire the specified bean into the field.
@Documented // It indicates that elements using that annotation should be documented by tools like Javadoc. The annotation will be included in the documentation for any method it annotates.
@Target({ElementType.FIELD}) // It means that the annotation can only be applied to fields. @Target can only be used to annotate other annotations.
@Retention(RetentionPolicy.RUNTIME) // The annotation is recorded in the compiled class file and retained by the JVM at runtime, making it accessible through reflection.
public @interface LazyAutowired {
//    String value() default "I am LazyAutowired. Can annotate a field/instances";
}
