package com.spring.koction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.koction.entity.Order;
import com.spring.koction.entity.OrderId;

public interface OrderRepository extends JpaRepository<Order, OrderId> {
	List<Order> findByUserUserId(String UserId);
}
