package com.udemy.spring.spring_selenium.page.google;

import com.udemy.spring.spring_selenium.custom_annotation.PageFragment;
import com.udemy.spring.spring_selenium.page.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;
//@Component // @Component by default, it will be a singleton scope. So the only one instance will be created and all the threads will be using the same instance. If you need a different scope, you can use the @Scope annotation to specify it.
@PageFragment
public class SearchComponent extends Base {
    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private List<WebElement> searchBtns;

    public void search(final String keyword){
        this.searchBox.sendKeys(keyword);
        this.searchBox.sendKeys(Keys.TAB);
        this.searchBtns
                .stream()
                .filter(e-> e.isDisplayed() && e.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public void clearSearchBox() { this.searchBox.clear(); }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until((d) -> this.searchBox.isDisplayed());
    }
}
