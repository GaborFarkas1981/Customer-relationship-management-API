package com.gfarkas.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Entity
@Data
@Table(name = "customer")
public class CustomerEntity {

    @Id
    private Long id;
    private String name;
    private String surename;
    private String email;
    private ZonedDateTime birthdate;
}
