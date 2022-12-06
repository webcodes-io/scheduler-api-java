package com.mops.scheduler.controllers;

import com.mops.scheduler.models.Employee;
import com.mops.scheduler.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> list() {
        return employeeRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Optional<Employee> get(@PathVariable UUID id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody final Employee employeeReq) {
        return employeeRepository.saveAndFlush(employeeReq);
    }
}
