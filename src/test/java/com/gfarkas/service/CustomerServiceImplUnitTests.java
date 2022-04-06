package com.gfarkas.service;

import com.gfarkas.CommonTestResource;
import com.gfarkas.dao.CustomerEntity;
import com.gfarkas.dao.CustomerRepository;
import com.gfarkas.dto.Customer;
import com.gfarkas.mapper.CustomerMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class CustomerServiceImplUnitTests extends CommonTestResource {

    @Mock
    CustomerRepository repository;

    @Mock
    CustomerMapper mapper;

    @InjectMocks
    CustomerServiceImpl service;

    private Customer actual;
    private final String expectedMessage = "Customer with id:";


    @BeforeEach
    void setup(TestInfo info) {
        MockitoAnnotations.openMocks(this);

        CustomerEntity customerEntity = createCustomerEntity();
        Customer customerDto = createCustomer(null, null, null, null);
        Customer customerDto2 = createCustomer("name2", "surename2", "email2",
                getBirthDate("June 8, 1981"));
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customerDto);
        customerList.add(customerDto2);

        Mockito.when(mapper.toCustomer(Mockito.any(CustomerEntity.class))).thenReturn(customerDto);
        Mockito.when(mapper.toCustomerEntity(Mockito.any(Customer.class))).thenReturn(customerEntity);
        Mockito.when(mapper.toCustomer(Mockito.anyList())).thenReturn(customerList);
        Mockito.when(repository.save(Mockito.any())).thenReturn(customerEntity);

        if (!info.getDisplayName().contains("ShouldThrowExceptionIfIdNotFound")) {
            Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(customerEntity));
            actual = service.get(1L);
        }
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
    void getShouldThrowExceptionIfIdNotFound() {
        Exception exception = Assertions.assertThrows(ResponseStatusException.class, () -> service.get(18L));
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void getShouldReturnDtoWithSameFields() {
        Assertions.assertEquals(surname, actual.getSurename());
        Assertions.assertEquals(name, actual.getName());
        Assertions.assertEquals(getBirthDate(null), actual.getBirthdate());
        Assertions.assertEquals(email, actual.getEmail());
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
    void updateShouldThrowExceptionIfIdNotFound() {
        Exception exception = Assertions.assertThrows(ResponseStatusException.class, () -> {
            Customer customer = createCustomer(null, null, null, null);
            service.update(18L, customer);
        });
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void delete() {
        Assertions.assertNotNull(service.delete(1L));
    }

    @Test
    void deleteShouldThrowExceptionIfIdNotFound() {
        Exception exception = Assertions.assertThrows(ResponseStatusException.class, () -> service.delete(18L));
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}