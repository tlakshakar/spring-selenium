package com.udemy.spring.cucumberwithspringboot;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        //features = "src/test/resources", // TODO: This works too. If you want to go ahead with this approach then enable this line and disable below line.
        features = "classpath:features", // Specifies the location of your feature files (test scenarios written in Gherkin language). In this case, it points to the directory "classpath:features", which means the feature files are located in the classpath under the features folder.
        glue = "com.udemy.spring.cucumberwithspringboot.BDD", // Defines the package(s) where your step definitions reside.
        //tags = "(@google and @smoke) or (@visa and @regression) or @flight",
        tags = "@flight",
        //tags = "@google and @smoke or @visa and @regression",
        plugin = { // Specifies the output formats for your test execution reports.
                "pretty", // Prints a human-readable summary of executed scenarios and steps to the console during test execution
                "html:target/cucumber-report.html", // Generates an HTML report in the specified directory.
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
/**
 * Extends the TestNG class to integrate Cucumber with TestNG.
 * This class runs your Cucumber scenarios as TestNG tests.
 */
public class CucumberRunner extends AbstractTestNGCucumberTests {
    @Override // This ensures that we’re overriding the scenarios() method from the superclass (AbstractTestNGCucumberTests)
    @DataProvider(parallel = true) // This annotation indicates that the data provider method (scenarios()) can run in parallel. In this case, it’s used to provide test scenarios to execute.
                                   // By setting parallel = true, TestNG will execute these scenarios in parallel threads, improving test execution efficiency.
    public Object[][] scenarios() {
        Object[][] scenarios = super.scenarios();
        System.out.println("Number of scenarios: " + scenarios.length);
        return super.scenarios(); // This invokes the superclass’s implementation of the scenarios() method. This method likely retrieves the Cucumber scenarios defined in your feature files.
    }
}