package com.udemy.spring.cucumberwithspringboot.spring_configurations.config;

/**
 * This configuration class sets up different WebDriver instances based on the active profile and properties.
 * It ensures that the appropriate driver is used depending on the environment and configuration settings.
 *
 * I have a similar class called "WebDriverConfig" that serves the same purpose.
 * However, in that class, we’ve also implemented a custom "@ThreadScopeBean" annotation and performed some code refactoring.
 */

// TODO: Disabling this class as we have WebDriverConfig

//@Lazy // It is not related to inject a bean uniquely
//@Configuration
/*@Profile("!remote")
@LazyConfiguration
public class WebDriverConfigWithoutThreadScopeBean {
    @Value("${default.timeout:30}")
    private int timeout;

    @Bean
    @Scope("prototype") // FIXME: The @Scope("prototype") annotation ensures that each time the chromeDriver bean is requested, a new instance of ChromeDriver will be created. This is problematic. As at many place, we have seen chromeDriver bean is requested which then opens multiple browsers. It's better to use BrowserScope.
    @ConditionalOnProperty(name = "browser", havingValue = "firefox") // Will comment this line to use Spring’s ApplicationContext to manage WebDriver instances for different browsers
    public WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    @Bean
    @Scope("browserscope") // Spring will look for this scope in its lifecycle.
    @ConditionalOnMissingBean // Will comment this line to use Spring’s ApplicationContext to manage WebDriver instances for different browsers
    public WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @Bean
    public WebDriverWait webDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(this.timeout));
    }
}*/
