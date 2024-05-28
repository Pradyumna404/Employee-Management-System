package com.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.demo.dao.EmployeeDao;
import com.demo.model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao ed;
	
	@Override
	public List<Employee> findAll() {
		return ed.findAll();
	}

	@Override
	public Employee add(Employee e) {
		return ed.save(e);
	}

	@Override
	public Optional<Employee> findById(int id){
	    return ed.findById(id);
	}

	@Override
	public void deleteById(int id) {
		ed.deleteById(id);
	}

	@Override
	public Employee update(int id, Employee e) {
		Optional<Employee> optionalEmployee = findById(id);
		if (optionalEmployee.isPresent()) {
		    Employee e2 = optionalEmployee.get();
		    e2.setName(e.getName());
			e2.setNo(e.getNo());
			e2.setGender(e.getGender());
			e2.setRole(e.getRole());
			e2.setSalary(e.getSalary());
			return ed.save(e2);
		} else {
			throw new NoSuchElementException("No employee found with id: " + id);
		}
	}

	@Override
	public void deleteAll() {
		ed.deleteAll();
	}

	@Override
    public List<Employee> search(String keyword) {
        return ed.search(keyword);
    }

	


	
	
	

}
