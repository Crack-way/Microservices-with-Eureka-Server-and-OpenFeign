package com.example.employeeservice.service;

import com.example.employeeservice.dto.AddressResponse;
import com.example.employeeservice.dto.EmployeeResponse;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.feignclient.AddressClient;
import com.example.employeeservice.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    private final AddressClient addressClient;

    private final RestTemplate restTemplate;

    private final LoadBalancerClient loadBalancerClient;



    public EmployeeResponse getEmployee(int id) {
        Employee employee = employeeRepo.findById(id).orElseThrow();

        EmployeeResponse employeeResponse = toResponseDto(employee);

        // manual way to get the  server instance information
//        ServiceInstance serviceInstance=loadBalancerClient.choose("address-app");
//        String uri=serviceInstance.getUri().toString();
//        String contextRoot=serviceInstance.getMetadata().get("configPath");
//        System.out.println(uri);
        AddressResponse addressResponse= addressClient.getAddressByEmployeeId(id);

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
