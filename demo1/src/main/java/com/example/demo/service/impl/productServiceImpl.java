package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.product;
import com.example.demo.repository.productRepository;
import com.example.demo.service.ProductService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class productServiceImpl implements ProductService{
	private final productRepository prdRepository;
	@Override
	public List<product> getAll() {
		// TODO Auto-generated method stub
		return prdRepository.findAll();
	}

	@Override
	public product getByCode(String code) {
		// TODO Auto-generated method stub
		return prdRepository.findById(code).orElse(null);
	}

	@Override
	public product save(product p) {
		// TODO Auto-generated method stub
		return prdRepository.save(p);
	}

	@Override
	public void delete(String code) {
		// TODO Auto-generated method stub
		prdRepository.deleteById(code);
	}

}
