package com.udemy.spring.spring_selenium.util;

import com.udemy.spring.spring_selenium.custom_annotation.LazyConfiguration;
import com.udemy.spring.spring_selenium.custom_annotation.PageAnnotations;
import jakarta.annotation.PostConstruct;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

//@Lazy // It is not related to inject a bean uniquely
//@Component
@LazyConfiguration
public class ScreenshotUtil {
    @Autowired
    private TakesScreenshot driver;

    //@Value("${screenshot.path}/img.png")
    @Value("${screenshot.path}")
    private Path fileWithPath;

    /**
     * This function will take screenshot.
     *
     * @param imageName
     */
    public void takeScreenshot(final String imageName) {
        try {
            String currentWorkingDir = System.getProperty("user.dir");
            System.out.println("Current working directory: " + currentWorkingDir);
            // Call getScreenshotAs method to create image file
            File SrcFile = this.driver.getScreenshotAs(OutputType.FILE);
            //FileCopyUtils.copy(SrcFile,this.fileWithPath.toFile());
            FileCopyUtils.copy(SrcFile,this.fileWithPath.resolve(imageName).toFile());
            System.out.println("Screenshot is captured");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Below code snippet is only to explain how LazyBean works
     */
    @PostConstruct
    public void init() {
        System.out.println(".....................................<START>.....................................");
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000); // Sleep for 1 second (1000 milliseconds)
                System.out.println("Doing heavy operations like DB, Searching or Indexing large documents............");
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("......................................<END>......................................");
    }
}
