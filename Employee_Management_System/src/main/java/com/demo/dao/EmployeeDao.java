package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	@Query("SELECT e FROM Employee e WHERE e.name LIKE %:keyword% OR e.no LIKE %:keyword% OR e.gender LIKE %:keyword% OR e.role LIKE %:keyword% OR CAST(e.id AS string) LIKE %:keyword% OR CAST(e.salary AS string) LIKE %:keyword%")
	List<Employee> search(@Param("keyword") String keyword);
	
}
