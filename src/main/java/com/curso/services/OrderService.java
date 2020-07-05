package com.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.entities.Order;
import com.curso.repositories.OrderRespositoy;

@Service
public class OrderService {
	
	@Autowired
	private OrderRespositoy userRespositoy;
	
	public List<Order> findAll(){
		return userRespositoy.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = userRespositoy.findById(id);
		return obj.get();
	}

}
