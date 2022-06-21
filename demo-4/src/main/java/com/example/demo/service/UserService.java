package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {
	public List<User> getAll();
	public User getById(String id);
	public User save(User u);
	public void deleteById(String id);
	
}
