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

class CustomerServiceImplTest {

    @Mock
    CustomerRepository repository;

    @Mock
    CustomerMapper mapper;

    @InjectMocks
    CustomerServiceImpl service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        ZoneId zoneId = ZoneId.of("UTC-1");
        ZonedDateTime birthDate = ZonedDateTime.of(2000, 10, 20, 23, 45, 0, 0, zoneId);
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
        customerDto.setSurename("sureName");
        customerDto.setId(1L);
        Mockito.when(mapper.toCustomer(Mockito.any())).thenReturn(customerDto);
    }

    @Test
    void getShouldReturnCustomerDtoById() {
       Assertions.assertNotNull(service.get(1L));
    }

    @Test
    void getShouldReturnDto() {
        Assertions.assertInstanceOf(Customer.class, service.get(1L));
    }

    @Test
    void list() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void handleException() {
    }
}