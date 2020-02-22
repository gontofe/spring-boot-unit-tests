package com.michaelrichardhall.springboottest.service;

import com.michaelrichardhall.springboottest.persistence.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployeeByName(String name);

    List<Employee> getAllEmployees();
}
