package com.spring.koction.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.koction.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	Page<Item> findByItemCategoryCategoryNo(int categoryNo, Pageable pageable);
}
