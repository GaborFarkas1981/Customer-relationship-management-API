package com.gfarkas.mapper;

import com.gfarkas.CommonTestResource;
import com.gfarkas.dao.CustomerEntity;
import com.gfarkas.dto.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;


@ExtendWith(MockitoExtension.class)
class CustomerMapperUnitTests extends CommonTestResource {

    @InjectMocks
    CustomerMapper mapper = new CustomerMapperImpl();

    @Test
    public void mapperShouldMapDtoToDao() {
        Customer dto = new Customer();

        dto.setBirthdate(getBirthDate(null));
        dto.setEmail(email);
        dto.setSurename(surname);
        dto.setName(name);
        CustomerEntity entity = mapper.toCustomerEntity(dto);

        Assertions.assertEquals(dto.getBirthdate(), entity.getBirthdate());
        Assertions.assertEquals(dto.getEmail(), entity.getEmail());
        Assertions.assertEquals(dto.getName(), entity.getName());
        Assertions.assertEquals(dto.getSurename(), entity.getSurename());

        Assertions.assertNull(entity.getId());
    }

    @Test
    public void mapperShouldMapDaoToDto() {
        CustomerEntity entity = new CustomerEntity();
        entity.setBirthdate(getBirthDate(null));
        entity.setEmail(email);
        entity.setSurename(surname);
        entity.setName(name);
        Customer dto = mapper.toCustomer(entity);

        Assertions.assertEquals(entity.getBirthdate(), dto.getBirthdate());
        Assertions.assertEquals(entity.getEmail(), dto.getEmail());
        Assertions.assertEquals(entity.getName(), dto.getName());
        Assertions.assertEquals(entity.getSurename(), dto.getSurename());

        Assertions.assertNull(dto.getId());
    }
}