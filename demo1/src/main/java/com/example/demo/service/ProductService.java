package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.product;

public interface ProductService {
	public List<product> getAll();
	public product getByCode(String code);
	public product save(product p);
	public void delete (String code);
}
