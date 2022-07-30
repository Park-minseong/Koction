package com.spring.koction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.koction.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
