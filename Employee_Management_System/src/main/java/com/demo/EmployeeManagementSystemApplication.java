package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.dao.PasswordDao;
import com.demo.model.password;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class EmployeeManagementSystemApplication {
@Autowired
private PasswordDao passwordDao;

public static void main(String[] args) {
    SpringApplication.run(EmployeeManagementSystemApplication.class, args);
}

@PostConstruct
public void init() {
    // Save a password entity
    password p = new password();
    p.setId(1);
    p.setUsername("admin");
    p.setPassword("pass");
    passwordDao.save(p);
}

}