package com.udemy.spring.cucumberwithspringboot;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        //features = "src/test/resources", // TODO: This works too. If you want to go ahead with this approach then enable this line and disable below line.
        features = "classpath:features", // Specifies the location of your feature files (test scenarios written in Gherkin language). In this case, it points to the directory "classpath:features", which means the feature files are located in the classpath under the features folder.
        glue = "com.udemy.spring.cucumberwithspringboot.BDD", // Defines the package(s) where your step definitions reside.
        tags = "@visa",
        plugin = { // Specifies the output formats for your test execution reports.
                "pretty", // Prints a human-readable summary of executed scenarios and steps to the console during test execution
                "html:build/reports/tests/cucumber/cucumber-report.html" // Generates an HTML report in the specified directory.
        }
)
/**
 * Extends the TestNG class to integrate Cucumber with TestNG.
 * This class runs your Cucumber scenarios as TestNG tests.
 */
public class CucumberRunner extends AbstractTestNGCucumberTests {}