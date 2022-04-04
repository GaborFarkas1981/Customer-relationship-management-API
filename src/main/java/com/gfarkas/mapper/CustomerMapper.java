package com.gfarkas.mapper;

import com.gfarkas.dao.CustomerEntity;
import com.gfarkas.dto.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CustomerMapper {
    @Mapping(target = "id", ignore = true)
    CustomerEntity toCustomerEntity(Customer customer);

    @Mapping(target = "id", ignore = true)
    Customer toCustomer(CustomerEntity entity);
}
