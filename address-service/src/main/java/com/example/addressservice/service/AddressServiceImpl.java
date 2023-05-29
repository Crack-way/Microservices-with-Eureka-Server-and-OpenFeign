package com.example.addressservice.service;


import com.example.addressservice.dto.AddressResponse;
import com.example.addressservice.entity.Address;
import com.example.addressservice.repo.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{

    private final AddressRepo addressRepo;
    @Override
    public AddressResponse toResponseDto(Address address) {
            AddressResponse addressResponse =new AddressResponse();

            addressResponse.setId(address.getId());
            addressResponse.setLocation(address.getLocation());
            addressResponse.setCountry(address.getCountry());
            return addressResponse;
        }

    @Override
    public AddressResponse getAddressByEmployeeId(int id) {

        Address address=addressRepo.findAddressByEmployeeId(id).orElseThrow();

        return toResponseDto(address);
    }


}
