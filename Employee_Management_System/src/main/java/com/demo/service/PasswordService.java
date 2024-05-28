package com.demo.service;

import com.demo.model.password;

public interface PasswordService {

	password update(Integer id,password p);
	password findById(int id);
	
}
