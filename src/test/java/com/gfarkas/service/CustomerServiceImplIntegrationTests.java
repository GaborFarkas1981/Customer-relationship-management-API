package com.gfarkas.service;

import com.gfarkas.CommonTestResource;
import com.gfarkas.dto.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class CustomerServiceImplIntegrationTests extends CommonTestResource {

    private final CustomerServiceImpl service;

    @Autowired
    public CustomerServiceImplIntegrationTests(CustomerServiceImpl service) {
        this.service = service;
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void getShouldReturnDtoByIdFromDb() {
        Customer customer = saveCustomer(null, null, null, null);
        Customer customerFromDb = service.get(3L);

        Assertions.assertNotNull(customerFromDb);
        Assertions.assertInstanceOf(Customer.class, customerFromDb);
        Assertions.assertEquals(customer.getName(), customerFromDb.getName());
        Assertions.assertEquals(customer.getSurename(), customerFromDb.getSurename());
        Assertions.assertEquals(customer.getEmail(), customerFromDb.getEmail());
        Assertions.assertEquals(customer.getBirthdate(), customerFromDb.getBirthdate());
    }

    private Customer saveCustomer(String customerName, String customerSurname, String customerEmail, Date customerBirthdate) {
        Customer customer = createCustomer(customerName, customerSurname, customerEmail, customerBirthdate);

        return service.create(customer);
    }
}
