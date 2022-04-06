package com.gfarkas.controller;

import com.gfarkas.dto.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * get() - Querying one specific customer
 * list() - Querying all the customers
 * create() - Creating a new customer
 * update() - Modifying an existing customer
 * delete() - Deleting an existing customer
 */
public interface CustomerServiceInterface {

    Customer get(Long id);

    List<Customer> list();

    Customer create(Customer customer);

    Customer update(Long id, Customer customer);

    Customer delete(Long id);
}
