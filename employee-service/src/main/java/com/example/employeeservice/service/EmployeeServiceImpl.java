package com.example.employeeservice.service;

import com.example.employeeservice.dto.AddressResponse;
import com.example.employeeservice.dto.EmployeeResponse;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final WebClient webClient;



    public EmployeeResponse getEmployee(int id) {
        Employee employee = employeeRepo.findById(id).orElseThrow();
        AddressResponse addressResponse=webClient.get().uri("/getAddress/"+id).retrieve().bodyToMono(AddressResponse.class).block();
        EmployeeResponse employeeResponse = toResponseDto(employee);
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }

    @Override
    public Employee toEmployee(EmployeeResponse employeeResponse) {
        Employee employee = new Employee();

        employee.setEmp_id(employeeResponse.getId());
        employee.setEmployeeName(employeeResponse.getEmployeeName());
        employee.setEmail(employeeResponse.getEmail());
        employee.setBloodGroup(employeeResponse.getBloodGroup());
        return employee;
    }

    @Override
    public EmployeeResponse toResponseDto(Employee employee) {

        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employee.getEmp_id());
        employeeResponse.setEmployeeName(employee.getEmployeeName());
        employeeResponse.setBloodGroup(employee.getBloodGroup());
        employeeResponse.setEmail(employee.getEmail());

        return employeeResponse;
    }


}
