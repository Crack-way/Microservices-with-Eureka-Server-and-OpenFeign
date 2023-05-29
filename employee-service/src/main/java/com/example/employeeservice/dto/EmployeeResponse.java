package com.example.employeeservice.dto;

import lombok.Data;


@Data
public class EmployeeResponse {


    private int id;


    private String employeeName;


    private String bloodGroup;

    private String email;

    private AddressResponse addressResponse;
}
