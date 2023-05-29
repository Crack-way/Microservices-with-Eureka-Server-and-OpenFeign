package com.example.employeeservice.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emp_id;

    @Column(name ="employee_name")
    private String employeeName;

    @Column(name="blood_group")
    private String bloodGroup;

    private String email;
}
