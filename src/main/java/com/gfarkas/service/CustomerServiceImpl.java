package com.gfarkas.service;

import com.gfarkas.controller.CustomerServiceInterface;
import com.gfarkas.dao.CustomerEntity;
import com.gfarkas.dao.CustomerRepository;
import com.gfarkas.dto.Customer;
import com.gfarkas.mapper.CustomerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
    @Transactional
    // A Proxy is Created that wraps the function retrieve
    // BeginTransaction
    public Customer get(Long id) {
        Optional<CustomerEntity> optionalCustomer = repository.findById(id);
        if (optionalCustomer.isPresent()) {
            return mapper.toCustomer(optionalCustomer.get());
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Customer with id: " + id + " not found!"
        );
    }
    // Commit Transaction

    @Override
    @Transactional
    public List<Customer> list() {
        return mapper.toCustomer(repository.findAll());
    }

    @Override
    @Transactional
    public Customer create(Customer customer) {
        CustomerEntity entity = mapper.toCustomerEntity(customer);
        CustomerEntity savedEntity = repository.save(entity);

        return mapper.toCustomer(savedEntity);
    }

    @Override
    @Transactional
    public Customer update(Long id, Customer customer) {
        Optional<CustomerEntity> customerOptional = repository.findById(id);
        if (customerOptional.isPresent()) {
            CustomerEntity existingCustomer = customerOptional.get();
            CustomerEntity customerToSave = mapper.toCustomerEntity(customer);
            customerToSave.setId(existingCustomer.getId());

            return mapper.toCustomer(repository.save(customerToSave));
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Customer with id: " + id + " not found!"
        );
    }

    @Override
    @Transactional
    public Customer delete(Long id) {
        // TODO: It's not a good practice to really erase something from the databse,
        // TODO: It would be better just to add a flag (IS_ACTIVE = False)
        Optional<CustomerEntity> customerOptional = repository.findById(id);
        if (customerOptional.isPresent()) {
            CustomerEntity existingCustomer = customerOptional.get();
            repository.delete(existingCustomer);

            return mapper.toCustomer(existingCustomer);
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Customer with id: " + id + " not found!"
        );
    }
}
