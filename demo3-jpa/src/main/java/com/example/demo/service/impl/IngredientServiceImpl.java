package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Ingredient;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.service.IngredientService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService{
	private final IngredientRepository ingredientRepository;
	@Override
	public List<Ingredient> getAll() {
		return ingredientRepository.findAll();
	}

	@Override
	public Ingredient getById(String id) {
		return ingredientRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(String id) {
		ingredientRepository.deleteById(id);
		
	}

	@Override
	public Ingredient save(Ingredient i) {
		return ingredientRepository.save(i);
	}
	
}
