package com.udemy.spring.spring_selenium.spring_boot_data_JPA.repository;

import com.udemy.spring.spring_selenium.spring_boot_data_JPA.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Repository annotation in Spring is used to indicate that a class serves as a repository.
 * It signifies that the decorated class provides mechanisms for storage, retrieval, update, deletion, and search operations on objects.
 *
 * JpaRepository is part of Spring Data JPA and provides common database operations.
 * By using @Repository, Spring will automatically detect and manage instances of CustomerRepository.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {}
