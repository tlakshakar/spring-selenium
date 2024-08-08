package com.udemy.spring.spring_selenium.page.redbus;

import com.udemy.spring.spring_selenium.page.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Scope("prototype")
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
