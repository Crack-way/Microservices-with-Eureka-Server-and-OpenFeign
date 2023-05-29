package com.example.employeeservice.controller;


import com.example.employeeservice.dto.EmployeeResponse;
import com.example.employeeservice.service.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class EmployeeController {


    private final EmployeeServiceImpl employeeService;

    @GetMapping("employees/{id}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable int id) {


        return ResponseEntity.ok().body(employeeService.getEmployee(id));

    }
}
