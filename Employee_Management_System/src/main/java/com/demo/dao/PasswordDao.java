package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.password;

public interface PasswordDao extends JpaRepository<password, Integer>{

	

}
