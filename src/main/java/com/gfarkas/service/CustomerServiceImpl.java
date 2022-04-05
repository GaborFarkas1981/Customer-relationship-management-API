package com.gfarkas.service;

import com.gfarkas.Exception.NoSuchElementFoundException;
import com.gfarkas.controller.CustomerServiceInterface;
import com.gfarkas.dao.CustomerEntity;
import com.gfarkas.dao.CustomerRepository;
import com.gfarkas.dto.Customer;
import com.gfarkas.mapper.CustomerMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerServiceInterface {

    final private CustomerRepository repository;
    final private CustomerMapper mapper;

    public CustomerServiceImpl(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Customer get(Long id) {
        Optional<CustomerEntity> optionalCustomer = repository.findById(id);
        if (optionalCustomer.isPresent()) {
            return mapper.toCustomer(optionalCustomer.get());
        }

        throw new NoSuchElementFoundException("Customer with id: " + id + " not found!");
    }

    @Override
    public List<Customer> list() {

        return mapper.toCustomers(repository.findAll());
    }

    @Override
    public Customer create(Customer customer) {

        // TODO: validation needed
        CustomerEntity entity = mapper.toCustomerEntity(customer);
        CustomerEntity savedEntity = repository.save(entity);

        return mapper.toCustomer(savedEntity);
    }

    @Override
    public Customer update(Long id, Customer customer) {
        Optional<CustomerEntity> customerOptional = repository.findById(id);
        CustomerEntity existingCustomer;
        if (customerOptional.isPresent()) {
            existingCustomer = customerOptional.get();
            CustomerEntity customerToSave = mapper.toCustomerEntity(customer);
            customerToSave.setId(existingCustomer.getId());

            return mapper.toCustomer(repository.save(customerToSave));
        }

        throw new NoSuchElementFoundException("Customer with id: " + id + " not found!");
    }

    @Override
    public Customer delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity handleException(Throwable t) {
        return null;
    }
}
