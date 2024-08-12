package com.udemy.spring.spring_selenium.spring_configurations.singleton_scope_annotation_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JuniorEng {
    @Autowired
    private Salary salary;

    public Salary getSalary() {
        return salary;
    }

    public void setAmount(int amount){
        this.salary.setAmount(amount);
    }
}
