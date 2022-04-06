package com.gfarkas;

import com.gfarkas.dao.CustomerEntity;
import com.gfarkas.dto.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class CommonTestResource {
    protected final String email = "some@one.com";
    protected final String surname = "sureName";
    protected final String name = "name";

    protected Date getBirthDate(String dateString) {
        if (dateString == null) {
            dateString = "January 2, 2010";
        }

        try {
            return new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Date();
    }

    protected Customer createCustomer(String customerName, String customerSurname, String customerEmail, Date customerBirthDate) {
        Customer customerDto = new Customer();
        customerDto.setName(Objects.requireNonNullElse(customerName, name));
        customerDto.setSurename(Objects.requireNonNullElse(customerSurname, surname));
        customerDto.setEmail(Objects.requireNonNullElse(customerEmail, email));
        customerDto.setBirthdate(Objects.requireNonNullElse(customerBirthDate, getBirthDate(null)));

        return customerDto;
    }

    protected CustomerEntity createCustomerEntity() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setBirthdate(getBirthDate(null));
        customerEntity.setEmail(email);
        customerEntity.setName(name);
        customerEntity.setSurename(surname);
        customerEntity.setId(1L);

        return customerEntity;
    }

}
