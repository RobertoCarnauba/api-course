package com.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.entities.Order;

public interface OrderRespositoy extends JpaRepository<Order, Long> {

}
