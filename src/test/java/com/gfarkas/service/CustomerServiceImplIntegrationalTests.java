package com.gfarkas.service;

import com.gfarkas.dto.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@SpringBootTest
class CustomerServiceImplIntegrationalTests {


    CustomerServiceImpl service;

    @Autowired
    public CustomerServiceImplIntegrationalTests(CustomerServiceImpl service) {
        this.service = service;
    }

	private Date birthDate;

	@BeforeEach
	void setUp() throws ParseException {
        String dateString = "January 2, 2010";
        birthDate = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(dateString);
	}

    @Test
    void contextLoads() {
    }

    @Test
    public void getShouldReturnDtoByIdFromDb() {
        Customer customer = createCustomer();
        Customer customerFromDb = service.get(3L);

        Assertions.assertNotNull(customerFromDb);
        Assertions.assertInstanceOf(Customer.class, customerFromDb);
        Assertions.assertEquals(customer.getName(), customerFromDb.getName());
        Assertions.assertEquals(customer.getSurename(), customerFromDb.getSurename());
        Assertions.assertEquals(customer.getEmail(), customerFromDb.getEmail());
        Assertions.assertEquals(customer.getBirthdate(), customerFromDb.getBirthdate());
    }

    private Customer createCustomer() {
        Customer customer = new Customer();
        customer.setName("John");
        customer.setSurename("Doe");
        customer.setEmail("john@doe.com");
        customer.setBirthdate(birthDate);

        return service.create(customer);
    }
}
