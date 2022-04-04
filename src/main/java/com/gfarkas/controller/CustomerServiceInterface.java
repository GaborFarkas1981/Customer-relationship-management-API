package com.gfarkas.controller;

import com.gfarkas.dao.CustomerEntity;
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

    CustomerEntity get(Long id);

    List<CustomerEntity> list();

    CustomerEntity create(CustomerEntity customerEntity);

    CustomerEntity update(Long id, CustomerEntity customerEntity);

    CustomerEntity delete(Long id);

    ResponseEntity handleException(Throwable t);
}
