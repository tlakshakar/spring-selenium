package com.udemy.spring.cucumberwithspringboot.page.google;

import com.udemy.spring.cucumberwithspringboot.spring_configurations.custom_annotation.PageFragment;
import com.udemy.spring.cucumberwithspringboot.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

//@Component // @Component by default, it will be a singleton scope. So the only one instance will be created and all the threads will be using the same instance. If you need a different scope, you can use the @Scope annotation to specify it.
@PageFragment
public class SearchResultComponent extends Base {
    @FindBy(css = "div.g")
    private List<WebElement> results;

    public int getCount(){
        return this.results.size();
    }

    @Override
    public boolean isAt() {
        return this.webDriverWait.until((d) -> !this.results.isEmpty());
    }
}
