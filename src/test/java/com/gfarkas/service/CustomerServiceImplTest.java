package com.gfarkas.service;

import com.gfarkas.dao.CustomerEntity;
import com.gfarkas.dao.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

class CustomerServiceImplTest {

    @Mock
    CustomerRepository repository;

    @InjectMocks
    CustomerServiceImpl service;

    private CustomerEntity customerEntity;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        ZoneId zoneId = ZoneId.of("UTC-1");
        ZonedDateTime birthDate = ZonedDateTime.of(2000, 10, 20, 23, 45, 0, 0, zoneId);
        customerEntity = new CustomerEntity();
        customerEntity.setBirthdate(birthDate);
        customerEntity.setEmail("email");
        customerEntity.setName("name");
        customerEntity.setSurename("sureName");
        customerEntity.setId(1L);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(customerEntity));
    }

    @Test
    void getShouldReturnOptionalEntityById() {
       Assertions.assertNotNull(service.get(1L));
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