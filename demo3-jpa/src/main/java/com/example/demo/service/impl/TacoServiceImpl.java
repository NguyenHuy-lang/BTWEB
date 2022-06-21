package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Taco;
import com.example.demo.repository.TacoRepository;
import com.example.demo.service.TacoService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class TacoServiceImpl implements TacoService{
	private final TacoRepository tacoRepository;
	@Override
	public List<Taco> getAll() {
		return tacoRepository.findAll();
	}

	@Override
	public Taco getById(String id) {
		return tacoRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(String id) {
		tacoRepository.deleteById(id);
		
	}

	@Override
	public Taco save(Taco i) {
		return tacoRepository.save(i);
	}
	
}
