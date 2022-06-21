package com.example.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.service.productService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class productServiceImpl implements productService{
	private final ProductRepository productRepository;
	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}
	@Transactional
	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}
	@Transactional
	@Override
	public void delete(String code) {
		productRepository.deleteById(code);
	}

	@Override
	public Product getByCode(String code) {
		return productRepository.findById(code).orElse(null);
		
	}

}
