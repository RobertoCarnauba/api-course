package com.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.entities.Product;
import com.curso.repositories.ProductRespositoy;

@Service
public class ProductService {
	
	@Autowired
	private ProductRespositoy productRespositoy;
	
	public List<Product> findAll(){
		return productRespositoy.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = productRespositoy.findById(id);
		return obj.get();
	}

	public Product insert(Product obj) {
		return productRespositoy.save(obj);
	}

}
