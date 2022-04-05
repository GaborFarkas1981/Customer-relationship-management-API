package com.gfarkas.service;

import com.gfarkas.dao.CustomerEntity;
import com.gfarkas.dao.CustomerRepository;
import com.gfarkas.dto.Customer;
import com.gfarkas.mapper.CustomerMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

class CustomerServiceImplTest {

    @Mock
    CustomerRepository repository;

    @Mock
    CustomerMapper mapper;

    @InjectMocks
    CustomerServiceImpl service;

    private Customer actual;
    private ZonedDateTime birthDate;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        ZoneId zoneId = ZoneId.of("UTC-1");
        birthDate = ZonedDateTime.of(2000, 10, 20, 23, 45, 0, 0, zoneId);
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setBirthdate(birthDate);
        customerEntity.setEmail("email");
        customerEntity.setName("name");
        customerEntity.setSurename("sureName");
        customerEntity.setId(1L);
        Customer customerDto = new Customer();
        customerDto.setBirthdate(birthDate);
        customerDto.setEmail("email");
        customerDto.setName("name");
        customerDto.setSurename("surename");
        Customer customerDto2 = new Customer();
        customerDto2.setBirthdate(birthDate);
        customerDto2.setEmail("email2");
        customerDto2.setName("name2");
        customerDto2.setSurename("surename2");
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customerDto);
        customerList.add(customerDto2);
        Mockito.when(mapper.toCustomer(Mockito.any())).thenReturn(customerDto);
        Mockito.when(mapper.toCustomerEntity(Mockito.any())).thenReturn(customerEntity);
        Mockito.when(mapper.toCustomers(Mockito.any())).thenReturn(customerList);
        Mockito.when(repository.save(Mockito.any())).thenReturn(customerEntity);
        actual = service.get(1L);
    }

    @Test
    void getShouldReturnCustomerDtoById() {

        Assertions.assertNotNull(actual);
    }

    @Test
    void getShouldReturnDto() {
        Assertions.assertInstanceOf(Customer.class, actual);
    }

    @Test
    void getShouldReturnDtoWithSameFields() {
        Assertions.assertEquals("surename", actual.getSurename());
        Assertions.assertEquals("name", actual.getName());
        Assertions.assertEquals(birthDate, actual.getBirthdate());
        Assertions.assertEquals("email", actual.getEmail());
    }

    @Test
    void listShouldReturnListOfCustomerDtos() {
        List<Customer> customers = service.list();
        Assertions.assertNotNull(customers);
        Assertions.assertEquals(2, customers.size());
    }

    @Test
    void createShouldReturnDto() {
        Assertions.assertNotNull(service.create(new Customer()));
    }

    @Test
    void updateShouldReturnDto() {
        Assertions.assertNotNull(service.update(1L, new Customer()));
    }

    @Test
    void delete() {
    }

    @Test
    void handleException() {
    }
}