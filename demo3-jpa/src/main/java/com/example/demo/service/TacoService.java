package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Taco;

public interface TacoService {
	public List<Taco> getAll();
	public Taco getById(String id);
	public void deleteById(String id);
	public Taco save(Taco i);


}
