package com.example.demo.service;

import java.util.List;

import com.example.demo.Entity.Product;

public interface productService {
	List<Product> getAll();
	Product save(Product product);
	void delete(String code);
	Product getByCode(String code);

}
