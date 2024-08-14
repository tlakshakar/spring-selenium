package com.udemy.spring.spring_selenium.page.google;

import com.udemy.spring.spring_selenium.spring_configurations.custom_annotation.PageFragment;
import com.udemy.spring.spring_selenium.page.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
                .stream() // Converts the 'buttons' collection into a stream, allowing for functional-style operations.
                .filter(e-> e.isDisplayed() && e.isEnabled()) // Filters the stream to include only those elements that are both displayed and enabled. This ensures that only clickable buttons are considered.
                .findFirst() // Finds the first element in the filtered stream
                .ifPresent(WebElement::click); // If an element is found (i.e., the Optional is not empty), it clicks the element
    }

    public void clearSearchBox() { this.searchBox.clear(); }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until((d) -> this.searchBox.isDisplayed());
    }
}
