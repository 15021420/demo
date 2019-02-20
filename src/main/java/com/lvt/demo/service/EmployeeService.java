package com.lvt.demo.service;

import com.lvt.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void callAll() {
        this.employee.method1();
        this.employee.method2();
        this.employee.method3();
        this.employee.method4();
    }

    public void callThrowable() {
        throw  new IllegalArgumentException();
    }
}
