package com.udemy.spring.spring_selenium.page.google;

import com.udemy.spring.spring_selenium.spring_configurations.custom_annotation.PageAnnotations;
import com.udemy.spring.spring_selenium.page.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * Yes, in Spring Boot, when you annotate a class with @Component, it is by default a singleton. This means that Spring will create only one instance of the bean, and this instance will be shared across the entire application context.
 * If you need a different scope, you can use the @Scope annotation to specify it. For example, to create a new instance every time the bean is requested, you can use @Scope("prototype").
 */
//@Lazy
//@Component
//@Scope("prototype")
@PageAnnotations
public class GooglePage extends Base {
    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private SearchResultComponent searchResultComponent;

    @Value("${application.google.url}")
    private String url;

    public void goTo() {
        this.driver.get(url);
    }

    public String getUrl() { return this.driver.getCurrentUrl(); }

    public String getGooglePageTitle() {
        return driver.getTitle();
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public SearchResultComponent getSearchResultComponent() {
        return searchResultComponent;
    }

    /**
     * Purpose of this provide hard delay only for debugging
     * @param millis
     */
    public void delay(int millis) {
        pauseExecution(millis);
    }

    public void close() {
        this.driver.quit();
    }

    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }
}
