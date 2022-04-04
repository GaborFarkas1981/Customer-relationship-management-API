package com.gfarkas.controller;

import com.gfarkas.dao.CustomerEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/customer")
@RestController
public class CustomerController {

    private final CustomerServiceInterface service;

    CustomerController(CustomerServiceInterface service) {
        this.service = service;
    }

    @GetMapping(value = {"/{id}"})
    public ResponseEntity<CustomerEntity> get(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(service.get(id), HttpStatus.OK);
        } catch (Throwable t) {
            return service.handleException(t);
        }
    }

    @GetMapping(value = {"/"})
    public ResponseEntity<List<CustomerEntity>> list() {
        try {
            return ResponseEntity.ok(service.list());
        } catch (Throwable t) {
            return service.handleException(t);
        }
    }

    @PostMapping(value = {"/"})
    public ResponseEntity<CustomerEntity> create(@RequestBody CustomerEntity entity) {
        try {
            return new ResponseEntity<>(service.create(entity), HttpStatus.OK);
        } catch (Throwable t) {
            return service.handleException(t);
        }
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<CustomerEntity> update(@PathVariable("id") Long id, @RequestBody CustomerEntity entity) {
        try {
            return new ResponseEntity<>(service.update(id, entity), HttpStatus.OK);
        } catch (Throwable t) {
            return service.handleException(t);
        }
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<CustomerEntity> delete(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
        } catch (Throwable t) {
            return service.handleException(t);
        }
    }
}
