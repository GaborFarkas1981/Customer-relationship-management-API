package com.gfarkas.service;

import com.gfarkas.controller.CustomerServiceInterface;
import com.gfarkas.dao.CustomerRepository;
import com.gfarkas.dto.Customer;
import com.gfarkas.mapper.CustomerMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return mapper.toCustomer(repository.getById(id));
    }

    @Override
    public List<Customer> list() {
        return null;
    }

    @Override
    public Customer create(Customer customer) {
        return null;
    }

    @Override
    public Customer update(Long id, Customer customer) {
        return null;
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
