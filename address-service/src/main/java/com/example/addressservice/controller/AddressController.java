package com.example.addressservice.controller;


import com.example.addressservice.entity.Address;
import com.example.addressservice.repo.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AddressController {

    private final AddressRepo addressRepo;

    @GetMapping("/getAddress/{id}")
    public ResponseEntity<Optional<Address>> getAddressByEmployeeId(@PathVariable int id){

       return ResponseEntity.ok().body(addressRepo.findAddressByEmployeeId(id));

    }
}
