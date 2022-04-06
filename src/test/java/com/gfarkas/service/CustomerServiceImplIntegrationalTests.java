package com.gfarkas.service;

import com.gfarkas.dto.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@SpringBootTest
class CustomerServiceImplIntegrationalTests {


    CustomerServiceImpl service;

    @Autowired
    public CustomerServiceImplIntegrationalTests(CustomerServiceImpl service) {
        this.service = service;
    }

	private  ZonedDateTime birthDate;

	@BeforeEach
	void setUp() {
		ZoneId zoneId = ZoneId.of("UTC-1");
		birthDate = ZonedDateTime.of(2000, 10, 20, 23, 45, 0, 0, zoneId);
	}

    @Test
    void contextLoads() {
    }

    @Test
    public void createShouldReturnCreatedDto() {
        Customer customer = new Customer();
        customer.setName("John");
        customer.setSurename("Doe");
        customer.setEmail("john@doe.com");
        customer.setBirthdate(birthDate);
		Customer customerInDb = service.create(customer);

		Assertions.assertNotNull(customerInDb);
        Assertions.assertInstanceOf(Customer.class, customerInDb);
        Assertions.assertEquals(customer.getName(), customerInDb.getName());
        Assertions.assertEquals(customer.getSurename(), customerInDb.getSurename());
        Assertions.assertEquals(customer.getEmail(), customerInDb.getEmail());
        Assertions.assertEquals(customer.getBirthdate(), customerInDb.getBirthdate());
	}
}
