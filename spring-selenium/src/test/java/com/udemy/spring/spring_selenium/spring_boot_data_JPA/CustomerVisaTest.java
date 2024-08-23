package com.udemy.spring.spring_selenium.spring_boot_data_JPA;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTests;
import com.udemy.spring.spring_selenium.spring_boot_data_JPA.entity.Customer;
import com.udemy.spring.spring_selenium.spring_boot_data_JPA.repository.CustomerRepository;
import com.udemy.spring.spring_selenium.spring_boot_data_JPA.visa.VisaRegistrationPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerVisaTest extends SpringBaseTestNGTests {
    private static final Logger logger = LoggerFactory.getLogger(CustomerVisaTest.class);
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private VisaRegistrationPage registrationPage;

    @Test
    public void visaTest1() {
        // Print number of records in user_visa.csv
        System.out.println("# Records: " + this.repository.findAll().size());
        // Print the record of Id = 55
        this.repository.findById(55).ifPresent(u -> System.out.println("Record[55]: " + u.getFirstName() + " " + u.getLastName()));
        // Print the record of Id = 159. This won't print anything as this record doesn't exist in user_visa.csv
        this.repository.findById(159).ifPresent(u -> System.out.println("Record[159]: " + u.getFirstName() + " " + u.getLastName()));
    }

    /**
     * Submit VISA for 3 customers
     */
    @Test
    public void visaTest3() {
        List<Customer> customers = this.repository.findAll() // This method retrieves all records from the repository
                .stream() // This converts the collection of records into a stream. Streams allow you to process elements sequentially or in parallel.
                .limit(3) // This limits the stream to the first three elements. In other words, it selects only the first three records from the stream.
                .collect(Collectors.toList()); // This collects the limited stream back into a list. The resulting list will contain at most three records.

        for (Customer u : customers) {
            logger.info("Inserting record of #"+u.getId());
            this.registrationPage.goTo();
            this.registrationPage.setNames(u.getFirstName(), u.getLastName());
            this.registrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
            this.registrationPage.setBirthDate(u.getDob().toLocalDate());
            this.registrationPage.setContactDetails(u.getEmail(), u.getPhone());
            this.registrationPage.setComments(u.getComments());
            this.registrationPage.submit();

            logger.info("Request confirmation # INFO : " + this.registrationPage.getConfirmationNumber());
            logger.warn("Request confirmation # WARN : " + this.registrationPage.getConfirmationNumber());
        }
    }

//    @DataProvider
//    @Test(dataProvider = "getData")
//    public void visaTest2(Customer u) {
//        this.registrationPage.goTo();
//        this.registrationPage.setNames(u.getFirstName(), u.getLastName());
//        this.registrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
//        this.registrationPage.setBirthDate(u.getDob().toLocalDate());
//        this.registrationPage.setContactDetails(u.getEmail(), u.getPhone());
//        this.registrationPage.setComments(u.getComments());
//        this.registrationPage.submit();
//
//        logger.info("Request confirmation # INFO : " + this.registrationPage.getConfirmationNumber());
//        logger.warn("Request confirmation # WARN : " + this.registrationPage.getConfirmationNumber());
//
//    }
//
//    @DataProvider
//    public Object[][] getData(ITestContext context) {
//        return this.repository.findByDobBetween(
//                        Date.valueOf("2000-01-01"),
//                        Date.valueOf("2010-01-01")
//                )
//                .stream()
//                .limit(3)
//                .map(o -> new Customer[]{o})
//                .toArray(Object[][]::new);
//    }
}
