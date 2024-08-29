package com.udemy.spring.cucumberwithspringboot.page;

import com.udemy.spring.cucumberwithspringboot.spring_configurations.config.LoggerConfig;
import com.udemy.spring.cucumberwithspringboot.spring_configurations.util.LoggingService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;


public abstract class Base {
    @Autowired
    protected WebDriver driver;
    @Autowired
    protected WebDriverWait webDriverWait;
    @Lazy
    @Autowired
    private LoggingService loggerConfig;

    /**
     * This method executes automatically as the bean is instantiated
     *
     * @PostConstruct annotated method will be invoked after the bean has been constructed using the default constructor
     * and just before its instance is returned to the requesting object. This cannot be static.
     *
     * @PostConstruct is used in Spring Framework to mark a method that should be executed after dependency injection has occurred.
     * It’s commonly used for tasks like setting up resources, populating DBs, initializing state, or performing other setup actions that depend on injected objects.
     *
     * In the post-construct phase, I aim to identify any/all @FindBy elements.
     * These elements should be find as part of the post-construct process, which occurs before the bean is fully prepared and provided to you.
     * Essentially, this method would have been invoked during that phase.
     *
     * init() method will be called automatically after the bean has been instantiated and its dependencies have been injected.
     */
    @PostConstruct
    public void init() {
        loggerConfig.debug(
                "Bean Base has been "
                        + "instantiated and I'm "
                        + "the init() method");
        PageFactory.initElements(this.driver,this);
    }
    /**
     * This method executes when the spring container is closed
     * @PreDestroy annotated method is invoked just before the bean is about to be destroyed inside the bean container.
     *
     */
    @PreDestroy
    public void destroy() {
        System.out.println("Container has been closed and I'm the destroy() method");
    }

    public abstract boolean isAt();

    /**
     * Purpose of this provide hard delay only for debugging
     *
     * @param millis
     */
    protected void pauseExecution(int millis) {
        try {
            Thread.sleep(millis);
        } catch(InterruptedException e) {
            // Handle interruption
            e.printStackTrace();
        }
    }
}
