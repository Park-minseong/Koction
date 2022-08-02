package com.spring.koction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.koction.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	List<Item> findByItemCategoryCategoryNo(int categoryNo);
}
