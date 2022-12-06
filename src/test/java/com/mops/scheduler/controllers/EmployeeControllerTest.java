package com.mops.scheduler.controllers;

import com.mops.scheduler.models.Employee;
import com.mops.scheduler.repos.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeControllerTest {
    Employee mockEmployee;
    ArrayList<Employee> employeeArrayList = new ArrayList<>();
    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeController employeeController;
    @BeforeEach
    public void initMocks(){
        MockitoAnnotations.openMocks(this);
    }
    @BeforeEach
    private void prepareMockResponse() {
        mockEmployee = new Employee(
                "John",
                "Doe",
                "john.doe@gmail.com",
                1234567890,
                "john.doe@gmail.com",
                "630 Rhode Island Ave NE, Washington, DC 20002, United States",
                "Sales",
                "EST"
        );
        mockEmployee.setId(UUID.randomUUID());
    }
    @Test
    public void listALlEmployees() {
        employeeArrayList.add(mockEmployee);
        when(employeeRepository.findAll()).thenReturn(employeeArrayList);
        assertEquals(employeeController.list().get(0),mockEmployee);
    }
}
