package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Ingredient;

public interface IngredientService {
	public List<Ingredient> getAll();
	public Ingredient getById(String id);
	public void deleteById(String id);
	public Ingredient save(Ingredient i);

}
