package com.example.employeeservice.feignclient;

import com.example.employeeservice.dto.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="address-app",path = "address-app/api")
public interface AddressClient{



    @GetMapping("/getAddress/{id}")
    AddressResponse getAddressByEmployeeId(@PathVariable int id);
}
