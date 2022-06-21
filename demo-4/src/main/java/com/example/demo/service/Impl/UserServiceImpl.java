package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	private final UserRepository userRepository;
	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User getById(String id) {
		return userRepository.findById(id).orElse(new User("-1","-1"));
	}

	@Override
	public User save(User u) {
		// TODO Auto-generated method stub
		return userRepository.save(u);
	}

	@Override
	public void deleteById(String id) {
		userRepository.deleteById(id);
	}

}
