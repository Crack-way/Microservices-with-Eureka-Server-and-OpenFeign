package com.example.addressservice.service;

import com.example.addressservice.dto.AddressResponse;
import com.example.addressservice.entity.Address;

public interface AddressService {


    AddressResponse toResponseDto(Address address);

    AddressResponse getAddressByEmployeeId(int id);

}
