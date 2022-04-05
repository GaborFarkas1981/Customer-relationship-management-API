package com.gfarkas.mapper;

import com.gfarkas.dao.CustomerEntity;
import com.gfarkas.dto.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZoneId;
import java.time.ZonedDateTime;


@ExtendWith(MockitoExtension.class)
class CustomerMapperTest {

    @InjectMocks
    CustomerMapper mapper = new CustomerMapperImpl();

    private ZonedDateTime birthDate;

    @Test
    public void mapperShouldMapDtoToDao() {
        Customer dto = new Customer();
        ZoneId zoneId = ZoneId.of("UTC-1");
        birthDate = ZonedDateTime.of(2000, 10, 20, 23, 45, 0, 0, zoneId);

        dto.setBirthdate(birthDate);
        dto.setEmail("some@one.com");
        dto.setSurename("sureName");
        dto.setName("name");
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
        entity.setBirthdate(birthDate);
        entity.setEmail("some@one.com");
        entity.setSurename("sureName");
        entity.setName("name");
        Customer dto = mapper.toCustomer(entity);

        Assertions.assertEquals(entity.getBirthdate(), dto.getBirthdate());
        Assertions.assertEquals(entity.getEmail(), dto.getEmail());
        Assertions.assertEquals(entity.getName(), dto.getName());
        Assertions.assertEquals(entity.getSurename(), dto.getSurename());

        Assertions.assertNull(dto.getId());

    }
}