package com.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.entities.OrderItem;

public interface OrderItemRespositoy extends JpaRepository<OrderItem, Long> {

}
