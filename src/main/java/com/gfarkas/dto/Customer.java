package com.gfarkas.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Customer {
    private Long id;
    private String name;
    private String surename;
    private String email;
    private ZonedDateTime birthdate;
}
