package com.udemy.spring.cucumberwithspringboot.spring_boot_data_JPA_page.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

/**
 * Entity class represent just 1 record in table
 * Do not create a class like 'Customers'. It will always be singular not plural.
 *
 * @Entity -- This annotation marks the Customer class as an entity.
 * Entities are Java objects that correspond to database tables.
 * When you annotate a class with @Entity, JPA recognizes it as a persistent entity and allows you to perform CRUD (Create, Read, Update, Delete) operations on it.
 *
 * @Table(name = "customer") -- This annotation specifies the name of the database table associated with the Customer entity.
 * In this case, the table name is “customer.” If you don’t provide the name attribute, JPA will use the class name (in this case, “Customer”) as the default table name.
 */
@Entity
@Table(name = "customer")
public class Customer {
    // user_visa.csv = id,from_country,to_country,dob,first_name,last_name,customer_email,phone,comments
    @Id // This annotation is used to indicate that the field is primary key in DB.
    private Integer id;
    private String fromCountry;
    private String toCountry;
    private Date dob; // java.sql.Date
    private String firstName;
    private String lastName;
    @Column(name = "customer_email") // This annotation is used to customize the mapping of a specific field to a database column.
    private String email;
    private String phone;
    private String comments;

    /**
     * ----------------------------------Getter-Setters----------------------------------
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromCountry() {
        return fromCountry;
    }

    public void setFromCountry(String fromCountry) {
        this.fromCountry = fromCountry;
    }

    public String getToCountry() {
        return toCountry;
    }

    public void setToCountry(String toCountry) {
        this.toCountry = toCountry;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * ----------------------------------------------------------------------------------
     */
}
