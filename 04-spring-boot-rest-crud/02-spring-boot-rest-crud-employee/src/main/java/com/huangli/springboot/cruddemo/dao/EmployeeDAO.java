package com.huangli.springboot.cruddemo.dao;

import com.huangli.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
