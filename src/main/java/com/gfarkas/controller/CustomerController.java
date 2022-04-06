package com.gfarkas.controller;

import com.gfarkas.dto.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "/api/customer")
@RestController
public class CustomerController {

    private final CustomerServiceInterface service;

    CustomerController(CustomerServiceInterface service) {
        this.service = service;
    }

    @GetMapping(value = {"/{id}"})
    public ResponseEntity<Customer> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @GetMapping(value = {"/"})
    public ResponseEntity<List<Customer>> list() {
        return ResponseEntity.ok(service.list());
    }

    @PostMapping(value = {"/"})
    public ResponseEntity<Customer> create(@Valid @RequestBody Customer entity) {
        return new ResponseEntity<>(service.create(entity), HttpStatus.OK);
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<Customer> update(@PathVariable("id") Long id, @Valid @RequestBody Customer entity) {
        return new ResponseEntity<>(service.update(id, entity), HttpStatus.OK);
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<Customer> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
