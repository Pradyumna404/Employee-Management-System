package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.PasswordDao;
import com.demo.model.password;

@Service
@Transactional
public class PasswordServiceImpl implements PasswordService{

	@Autowired
	private PasswordDao pd;
	
	public password update(Integer id,password p) {
		password p2=pd.findById(id).orElseThrow();
		    p2.setPassword(p.getPassword());
			
			return pd.save(p2);
		
	}

	@Override
	public password findById(int id) {
		return pd.findById(id).orElseThrow();
	}
	
	

}
