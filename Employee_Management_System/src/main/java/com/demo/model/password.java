package com.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class password {

	@Id
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String username;
	private String password;
	@Override
	public String toString() {
		return "password [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}
}
