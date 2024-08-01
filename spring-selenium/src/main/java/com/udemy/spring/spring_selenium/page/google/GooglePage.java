package com.udemy.spring.spring_selenium.page.google;

import com.udemy.spring.spring_selenium.page.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
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

    public String getGooglePageTitle() {
        return driver.getTitle();
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public SearchResultComponent getSearchResultComponent() {
        return searchResultComponent;
    }

    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }
}
