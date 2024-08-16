package com.udemy.spring.spring_selenium.page.window;

import com.udemy.spring.spring_selenium.page.Base;
import com.udemy.spring.spring_selenium.spring_configurations.custom_annotation.PageAnnotations;

@PageAnnotations
public class MainPage extends Base {
    @Override
    public boolean isAt() {
        return false;
    }
}
