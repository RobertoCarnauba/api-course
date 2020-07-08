package com.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.entities.Category;
import com.curso.repositories.CategoryRespositoy;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRespositoy categoryRespositoy;
	
	public List<Category> findAll(){
		return categoryRespositoy.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = categoryRespositoy.findById(id);
		return obj.get();
	}

}
