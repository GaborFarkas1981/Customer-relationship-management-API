package com.gfarkas.mapper;

import com.gfarkas.dao.CustomerEntity;
import com.gfarkas.dto.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface CustomerMapper {
    @Mapping(target = "id", ignore = true)
    CustomerEntity toCustomerEntity(Customer customer);

    @Mapping(target = "id", ignore = true)
    List<CustomerEntity> toCustomerEntities(List<Customer> customers);

    @Mapping(target = "id", ignore = true)
    Customer toCustomer(CustomerEntity entity);

    @Mapping(target = "id", ignore = true)
    List<Customer> toCustomers(List<CustomerEntity> entities);
}