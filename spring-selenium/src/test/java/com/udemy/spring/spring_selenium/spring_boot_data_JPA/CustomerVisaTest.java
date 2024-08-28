package com.udemy.spring.spring_selenium.spring_boot_data_JPA;

import com.udemy.spring.spring_selenium.SpringBaseTestNGTests;
import com.udemy.spring.spring_selenium.spring_boot_data_JPA.entity.Customer;
import com.udemy.spring.spring_selenium.spring_boot_data_JPA.repository.CustomerRepository;
import com.udemy.spring.spring_selenium.spring_boot_data_JPA.visa.VisaRegistrationPage;
import com.udemy.spring.spring_selenium.spring_configurations.util.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerVisaTest extends SpringBaseTestNGTests {
//    private static final Logger logger = LoggerFactory.getLogger(CustomerVisaTest.class); // TODO: This works. Enable this line and disable below LoggingService line
    @Autowired
    private LoggingService logger; // It is a bean
    //private LoggingService logger = new LoggingService(); // No need as we already created LoggerConfig to allow Spring to manage it

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private VisaRegistrationPage registrationPage;

    @Test
    @Ignore
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
    @Ignore
    public void visaTest2() {
        List<Customer> customers = this.repository.findAll() // This method retrieves all records from the repository
                .stream() // This converts the collection of records into a stream. Streams allow you to process elements sequentially or in parallel.
                .limit(3) // This limits the stream to the first three elements. In other words, it selects only the first three records from the stream.
                .collect(Collectors.toList()); // This collects the limited stream back into a list. The resulting list will contain at most three records.

        for (Customer u : customers) {
            logger.info("Submitting record of #"+u.getId());
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

    /**
     * Submit the records of users whose firstName starts-with "Ch" from user-visa.csv
     */
    @Test
    @Ignore
    public void visaTest3() {
        List<Customer> customers = this.repository.findByFirstNameStartingWith("Ch") // This method retrieves all records from the repository
                .stream() // This converts the collection of records into a stream. Streams allow you to process elements sequentially or in parallel.
                .collect(Collectors.toList()); // This collects the limited stream back into a list. The resulting list will contain at most three records.

        for (Customer u : customers) {
            logger.info("Submitting record of #"+u.getId());
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

    @Ignore
    @DataProvider
    @Test(dataProvider = "getData")
    public void visaTest4(Customer u) {
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

    @DataProvider
    public Object[][] getData(ITestContext context) {
        return this.repository.findByDobBetween(
                        Date.valueOf(context.getCurrentXmlTest().getParameter("dobStartFrom")),
                        Date.valueOf(context.getCurrentXmlTest().getParameter("dobEndTo"))
                )
                .stream()
                .limit(3) // limits the stream to the first 3 elements.
                .map(o -> new Customer[]{o}) // maps each element to an array of Customer objects.
                .toArray(Object[][]::new); // converts the stream to a 2D array of Object.
    }

    /**
     * Verify that new records are inserted in Customer DB via data.sql and respective dependencies are defined under application.properties
     */
    @Test
    public void visaTest5() {
        // Print number of records in user_visa.csv
        logger.info("# Records: " + this.repository.findAll().size());
        // Print the record of Id = 101
        this.repository.findById(101).ifPresent(u -> logger.info("Record[101]: " + u.getFirstName() + " " + u.getLastName()));
        // Print the record of Id = 102. This won't print anything as this record doesn't exist in user_visa.csv
        this.repository.findById(102).ifPresent(u -> logger.info("Record[102]: " + u.getFirstName() + " " + u.getLastName()));
        // Print the record of Id = 103. This won't print anything as this record doesn't exist in user_visa.csv
        this.repository.findById(103).ifPresent(u -> logger.info("Record[103]: " + u.getFirstName() + " " + u.getLastName()));
        // Print the record of Id = 104. This won't print anything as this record doesn't exist in user_visa.csv
        this.repository.findById(104).ifPresent(u -> logger.info("Record[104]: " + u.getFirstName() + " " + u.getLastName()));

        logger.info("Deleting record: [104]");
        this.repository.deleteById(104); // Deleting 1 record by ID

        // Print number of records in user_visa.csv
        logger.info("# Records: " + this.repository.findAll().size());
        // Print the record of Id = 101
        this.repository.findById(101).ifPresent(u -> logger.info("Record[101]: " + u.getFirstName() + " " + u.getLastName()));
        // Print the record of Id = 102
        this.repository.findById(102).ifPresent(u -> logger.info("Record[102]: " + u.getFirstName() + " " + u.getLastName()));
        // Print the record of Id = 103
        this.repository.findById(103).ifPresent(u -> logger.info("Record[103]: " + u.getFirstName() + " " + u.getLastName()));
        // Print the record of Id = 104
        this.repository.findById(104).ifPresent(u -> logger.info("Record[104]: " + u.getFirstName() + " " + u.getLastName()));

        /**
         * Inserting new record - [104]
         */
        logger.info("Inserting record: [444]");
        Customer newCustomer = new Customer();
        newCustomer.setId(444);
        newCustomer.setFirstName("Rakefet");
        newCustomer.setLastName("Shimony");
        newCustomer.setFromCountry("Israel");
        newCustomer.setToCountry("India");
        newCustomer.setDob(Date.valueOf("2011-05-31"));
        newCustomer.setPhone("1-572-883-1594");
        newCustomer.setEmail("rakefet.shimony@nobody.com");
        newCustomer.setComments("To insert data using Spring Data JPA with an H2 database");
        this.repository.save(newCustomer);

        // Print the record of Id = 444
        this.repository.findById(444).ifPresent(u -> logger.info("Inserted Record[444]: " + u.getFirstName() + " " + u.getLastName() + " " + u.getEmail() + " " + u.getDob()));

        this.registrationPage.goTo();
        this.registrationPage.setNames(newCustomer.getFirstName(), newCustomer.getLastName());
        this.registrationPage.setCountryFromAndTo(newCustomer.getFromCountry(), newCustomer.getToCountry());
        this.registrationPage.setBirthDate(newCustomer.getDob().toLocalDate());
        this.registrationPage.setContactDetails(newCustomer.getEmail(), newCustomer.getPhone());
        this.registrationPage.setComments(newCustomer.getComments());
        this.registrationPage.submit();

        logger.logMessage("Request confirmation  : " + this.registrationPage.getConfirmationNumber());
        logger.info("Request confirmation # INFO : " + this.registrationPage.getConfirmationNumber());
        logger.warn("Request confirmation # WARN : " + this.registrationPage.getConfirmationNumber());
    }
}
