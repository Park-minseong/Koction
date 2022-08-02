package com.spring.koction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.koction.entity.ItemCategory;

public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Integer>{
	
}
