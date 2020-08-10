package com.app.HRManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.HRManagementSystem.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
