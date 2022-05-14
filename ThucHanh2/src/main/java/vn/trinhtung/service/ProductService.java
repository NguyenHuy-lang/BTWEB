package vn.trinhtung.service;

import java.util.List;

import vn.trinhtung.entity.Product;

public interface ProductService {
	List<Product> getAll();
	
	Product save(Product product);
	
	void delete(String code);
	
	Product getByCode(String code);
}
