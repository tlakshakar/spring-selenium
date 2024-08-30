package com.udemy.spring.cucumberwithspringboot.spring_configurations.util;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Purpose of this class "ScreenshotUtil" is to take screenshots and save them to a specified path.
 */

@Lazy // It is not related to inject a bean uniquely
//@Component // this also works before using @Service
@Service // This is used to mark a class as a service provider. This annotation is a specialization of the @Component annotation, which means it is also a Spring-managed component. Use @Service to annotate classes that perform service tasks, such as business logic or data manipulation.
public class ScreenshotService {
    /**
     * FIXME - In the 1st run/execution, "TakesScreenshot driver" will be quit later and
     * for the next run ScreenshotUtil won't hold reference of newly created "TakesScreenshot driver".
     * when we try to take the screenshot, ScreenshotUtil will say that, hey spring you gave me webdriver instance using which I am taking screenshot but it seems you quit the webdriver. Did you quit?
     *
     * TODO: We need to fix this issue!! --> ApplicationContext will help
     */
//    @Autowired
//    private TakesScreenshot driver;

    @Autowired
    private ApplicationContext ctx;

    //@Value("${screenshot.path}/img.png")
    @Value("${screenshot.path}")
    private Path fileWithPath;

    @Autowired
    private Faker faker;

    /**
     * This function will take screenshot.
     * Purpose: Used to get a WebDriver instance capable of taking screenshots.
     *
     * @param imageName
     */
    public void takeScreenshot(final String imageName) {
        try {
            String currentWorkingDir = System.getProperty("user.dir") + FileSystems.getDefault().getSeparator() + "screenshots";
            System.out.println("Current working directory: " + currentWorkingDir);

            // Call getScreenshotAs method to create image file
//            File SrcFile = this.driver.getScreenshotAs(OutputType.FILE); // FIXME: We need to fix the ISSUE --> ApplicationContext

            checkBean();

            // ctx.getBean() --> Retrieve a bean that implements the TakesScreenshot interface.
            // This line sends a request to the IoC container (Spring Container).
            // As we all know that, several WebDriver implementations  in Selenium support the TakesScreenshot interface.
                // ChromeDriver: Implements TakesScreenshot.
                // FirefoxDriver: Implements TakesScreenshot.
                // InternetExplorerDriver: Implements TakesScreenshot.
                // EdgeDriver: Implements TakesScreenshot.
                // OperaDriver: Implements TakesScreenshot.
            // The getBean method is used to retrieve a bean from the Spring container. By passing TakesScreenshot.class as an argument, you are asking the container to return a bean that implements the TakesScreenshot interface.
            // Each time a screenshot is taken, it contacts the Spring container to get a bean.
            // It's like asking the Spring container, "Do you have a bean for me?"
            // The Spring container responds, "Yes, you're coming from x-thread, and I have a WebDriver instance ready for you."
            // Therefore, ctx.getBean() is invoked only when the takeScreenshot() method is called.
            File SrcFile = ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);

            FileCopyUtils.copy(SrcFile, this.fileWithPath.resolve(imageName + ".png").toFile()); // Create screenshot with random name
            System.out.println("Screenshot is captured");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This function will take screenshot with random name
     * Purpose: Used to get a WebDriver instance capable of taking screenshots.
     */
    public void takeScreenshot() {
        try {
            String currentWorkingDir = System.getProperty("user.dir") + FileSystems.getDefault().getSeparator() + "screenshots";
            System.out.println("Current working directory: " + currentWorkingDir);

            // Call getScreenshotAs method to create image file
//            File SrcFile = this.driver.getScreenshotAs(OutputType.FILE); // FIXME: We need to fix the ISSUE --> ApplicationContext

            checkBean();

            // ctx.getBean() --> Retrieve a bean that implements the TakesScreenshot interface.
            // This line sends a request to the IoC container (Spring Container).
            // As we all know that, several WebDriver implementations  in Selenium support the TakesScreenshot interface.
                // ChromeDriver: Implements TakesScreenshot.
                // FirefoxDriver: Implements TakesScreenshot.
                // InternetExplorerDriver: Implements TakesScreenshot.
                // EdgeDriver: Implements TakesScreenshot.
                // OperaDriver: Implements TakesScreenshot.
            // The getBean method is used to retrieve a bean from the Spring container. By passing TakesScreenshot.class as an argument, you are asking the container to return a bean that implements the TakesScreenshot interface.
            // Each time a screenshot is taken, it contacts the Spring container to get a bean.
            // It's like asking the Spring container, "Do you have a bean for me?"
            // The Spring container responds, "Yes, you're coming from x-thread, and I have a WebDriver instance ready for you."
            // Therefore, ctx.getBean() is invoked only when the takeScreenshot() method is called.
            File SrcFile = ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);

            FileCopyUtils.copy(SrcFile, this.fileWithPath.resolve(faker.name().title() + ".png").toFile()); // Create screenshot with random name
            System.out.println("Screenshot is captured");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is used in CucumberHooks scenario where it is returning byte[]
     * Inside the method:
     *      this.ctx.getBean(TakesScreenshot.class) retrieves an instance of TakesScreenshot from the Spring application context.
     *      .getScreenshotAs(OutputType.BYTES) captures a screenshot and returns it as a byte array.
     * @return
     */
    public byte[] getScreenshot() {
        return this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Purpose of this is to check if a bean implements the TakesScreenshot interface
     */
    private void checkBean() {
        TakesScreenshot screenshotBean = ctx.getBean(TakesScreenshot.class);
        if (screenshotBean != null) {
            System.out.println("The bean implements TakesScreenshot.");
        } else {
            System.out.println("The bean does not implement TakesScreenshot.");
        }
    }

    /**
     * Below code snippet is only to explain how LazyBean works
     */
    @PostConstruct
    public void init() {
        System.out.println("................................................<START>................................................");
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000); // Sleep for 1 second (1000 milliseconds)
                System.out.println("<ScreenshotService> - Doing heavy operations like DB, Searching or Indexing large documents............");
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(".................................................<END>.................................................");
    }
}
