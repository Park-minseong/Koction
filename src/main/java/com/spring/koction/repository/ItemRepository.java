package com.spring.koction.repository;

import java.util.List;

import com.spring.koction.entity.CustomUserDetails;
import com.spring.koction.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.koction.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	List<Item> findByUserUserId(String userId);
	Page<Item> findByItemCategoryCategoryNo(int categoryNo, Pageable pageable);
}
