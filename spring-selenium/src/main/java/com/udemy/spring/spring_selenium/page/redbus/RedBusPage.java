package com.udemy.spring.spring_selenium.page.redbus;

import com.udemy.spring.spring_selenium.custom_annotation.PageAnnotations;
import com.udemy.spring.spring_selenium.page.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Yes, in Spring Boot, when you annotate a class with @Component, it is by default a singleton. This means that Spring will create only one instance of the bean, and this instance will be shared across the entire application context.
 * If you need a different scope, you can use the @Scope annotation to specify it. For example, to create a new instance every time the bean is requested, you can use @Scope("prototype").
 */
//@Lazy
//@Component
//@Scope("prototype")
@PageAnnotations
public class RedBusPage extends Base {
    @Value("${application.url}")
    private String url;
    @Autowired
    private SearchBus searchBus;
    @Autowired
    private SearchResults searchResults;

    public SearchBus getSearchBus() {
        return this.searchBus;
    }
    public SearchResults getSearchResults() {
        return this.searchResults;
    }
    public void goTo() {
        driver.get(url);
    }
    public void maximizeWindow() { driver.manage().window().maximize(); }
    @Override
    public boolean isAt() {
        return this.searchBus.isAt();
    }

    /**
     * Purpose of this provide hard delay only for debugging
     * @param millis
     */
    public void delay(int millis) {
        pauseExecution(millis);
    }
}
