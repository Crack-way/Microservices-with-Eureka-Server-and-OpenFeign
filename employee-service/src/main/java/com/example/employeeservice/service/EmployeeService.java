package com.example.employeeservice.service;

import com.example.employeeservice.dto.EmployeeResponse;
import com.example.employeeservice.entity.Employee;

public interface EmployeeService {
    EmployeeResponse getEmployee(int id);

    Employee toEmployee(EmployeeResponse employeeResponse);
    EmployeeResponse toResponseDto(Employee employee);

}
