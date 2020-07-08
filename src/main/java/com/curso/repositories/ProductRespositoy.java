package com.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.entities.Product;

public interface ProductRespositoy extends JpaRepository<Product, Long> {

}
