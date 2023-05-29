package com.example.addressservice.dto;


import lombok.Data;

@Data
public class AddressResponse {

    private int id;

    private String location;

    private String country;
}
