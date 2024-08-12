package com.udemy.spring.spring_selenium.singleton_scope_annotation_demo;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTests;
import com.udemy.spring.spring_selenium.spring_configurations.singleton_scope_annotation_demo.JuniorEng;
import com.udemy.spring.spring_selenium.spring_configurations.singleton_scope_annotation_demo.SeniorEng;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class JuniorSeniorTest extends SpringBaseTestNGTests {
    @Autowired
    private JuniorEng junior;
    @Autowired
    private SeniorEng senior;

    @Test
    @Ignore
    public void scopeTest() {
        this.junior.setAmount(100);
        System.out.println("Junior :: " + this.junior.getSalary().getAmount() + "$");
        this.senior.setAmount(200);
        System.out.println("Senior :: " + this.senior.getSalary().getAmount() + "$");
        System.out.println("Junior :: " + this.junior.getSalary().getAmount() + "$");
    }
}
