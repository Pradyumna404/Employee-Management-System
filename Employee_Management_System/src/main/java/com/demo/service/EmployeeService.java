package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.demo.model.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	Employee add(Employee e);
	Optional<Employee> findById(int id);
	void deleteById(int id);
	Employee update(int id, Employee e);
	void deleteAll();
	List<Employee> search(String keyword);
}
