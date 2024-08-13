package com.udemy.spring.spring_selenium.resourcesTests.resourcesAccessTests;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Ignore
public class ReadResourceTest extends SpringBaseTestNGTests {
    // File is a part of project
    @Value("classpath:data/testdata.csv")
    private Resource classPathResource;

    //--------------------------------------------------------------------------------------------------------------------------------//

    // File is not part of project instead external file-system (not within project)
    @Value("file:\\SeleniumTestAutomationWithSprintBoot\\udemy-spring-selenium\\spring-selenium\\testdata.csv")
    private Resource filePathResource;

    //--------------------------------------------------------------------------------------------------------------------------------//

    // File is a part of website
    @Value("https://www.w3.org/Graphics/GIF/spec-gif89a.txt")
    private Resource webPathResource;
    @Value("${file.path}/some.txt")
    private Path path;

    //--------------------------------------------------------------------------------------------------------------------------------//

    // File is a part of project
    @Value("classpath:data/dynamicdata.csv")
    private Resource dynamicResource;
    @Value("${file.path}")
    private Path path1;
    @Autowired
    private ResourceLoader resourceLoader;

    //--------------------------------------------------------------------------------------------------------------------------------//

    @Test
    public void readResourceDataFromFilePresentInProject() throws IOException {
        Files.readAllLines(classPathResource.getFile().toPath())
                .forEach(System.out::println);
    }

    //--------------------------------------------------------------------------------------------------------------------------------//

    @Test
    public void readResourceDataFromFileSystem() throws IOException {
        Files.readAllLines(filePathResource.getFile().toPath())
                .forEach(System.out::println);
    }

    //--------------------------------------------------------------------------------------------------------------------------------//

    /**
     * The method reads data from webPathResource, prints it to the console, and then copies the same data to a file specified by path
     * Basically we are downloading file from a webpage
     *
     * @throws IOException
     */
    @Test
    public void readResourceDataFromWebsite() throws IOException {
        // Files.readAllLines(webPathResource.getFile().toPath()).forEach(System.out::println); // This won't work here as URL [https://www.google.com] cannot be resolved to absolute file path because it does not reside in the file system.

        /**
         * webPathResource.getInputStream(): Obtains an InputStream from the webPathResource.
         * readAllBytes(): Reads all bytes from the InputStream into a byte array.
         */
        System.out.println(new String(webPathResource.getInputStream().readAllBytes()));

        /**
         * Copies the data from the InputStream to the OutputStream.
         *
         * webPathResource.getInputStream(): Again, obtains an InputStream from the webPathResource.
         * Files.newOutputStream(path): Creates an OutputStream to the specified file path.
         * FileCopyUtils.copy(...): Copies the data from the InputStream to the OutputStream.
         */
        FileCopyUtils.copy(webPathResource.getInputStream(), Files.newOutputStream(path)); // Copying resource data to a file
    }

    //--------------------------------------------------------------------------------------------------------------------------------//

    /**
     * The getData() method reads data from a file, splits each line by commas, and returns it as a two-dimensional array of Object.
     * @return
     * @throws IOException
     */
    @DataProvider
    public Object[][] getData() throws IOException {
        return Files.readAllLines(dynamicResource.getFile().toPath())
                .stream()
                .map(s -> s.split(","))
                .toArray(Object[][]::new);
    }

    /**
     * The resourceTest method uses this data to copy resources specified by URLs to files with specified names
     * @param url
     * @param saveAs
     * @throws IOException
     */
    @Test(dataProvider = "getData")
    public void readDynamicResourceData(String url, String saveAs) throws IOException {
        /**
         * resourceLoader.getResource(url).getInputStream(): Obtains an InputStream from the resource specified by the url.
         * Files.newOutputStream(path.resolve(saveAs)): Creates an OutputStream to the file specified by saveAs in the path directory.
         * FileCopyUtils.copy(...): Copies the data from the InputStream to the OutputStream
         */
        FileCopyUtils.copy(
                resourceLoader.getResource(url).getInputStream(),
                Files.newOutputStream(path1.resolve(saveAs)) // where to save
        );
    }

    //--------------------------------------------------------------------------------------------------------------------------------//
}
