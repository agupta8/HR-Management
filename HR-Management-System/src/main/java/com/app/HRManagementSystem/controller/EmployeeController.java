package com.app.HRManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.HRManagementSystem.model.Employee;
import com.app.HRManagementSystem.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepo;

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void addEmployee(@RequestBody Employee emp) {
		employeeRepo.save(emp);
	}

	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Optional<Employee> getEmployee(@RequestParam int id) {
		Optional<Employee> employee = employeeRepo.findById(id);
		return employee;
	}

	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String deleteEmployee(@RequestParam int id) {
		employeeRepo.deleteById(id);
		return "Id : " + id + " deleted";
	}

}
