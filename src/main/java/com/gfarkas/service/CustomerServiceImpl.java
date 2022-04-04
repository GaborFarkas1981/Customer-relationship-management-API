package com.gfarkas.service;

import com.gfarkas.controller.CustomerServiceInterface;
import com.gfarkas.dao.CustomerEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerServiceInterface {
    @Override
    public CustomerEntity get(Long id) {
        return null;
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
