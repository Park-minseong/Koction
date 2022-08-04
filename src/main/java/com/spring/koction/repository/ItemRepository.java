package com.spring.koction.repository;

import java.util.List;

import com.spring.koction.entity.CustomUserDetails;
import com.spring.koction.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.koction.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	List<Item> findByItemCategoryCategoryNo(int categoryNo);
	List<Item> findByUserUserId(String userId);
}
