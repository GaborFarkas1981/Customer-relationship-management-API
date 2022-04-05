package com.gfarkas.service;

import com.gfarkas.controller.CustomerServiceInterface;
import com.gfarkas.dao.CustomerEntity;
import com.gfarkas.dao.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerServiceInterface {

    final private CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerEntity get(Long id) {
        return repository.getById(id);
    }

    @Override
    public List<CustomerEntity> list() {
        return null;
    }

    @Override
    public CustomerEntity create(CustomerEntity customerEntity) {
        return null;
    }

    @Override
    public CustomerEntity update(Long id, CustomerEntity customerEntity) {
        return null;
    }

    @Override
    public CustomerEntity delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity handleException(Throwable t) {
        return null;
    }
}
