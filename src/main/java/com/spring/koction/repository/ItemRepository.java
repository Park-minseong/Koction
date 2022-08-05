package com.spring.koction.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.koction.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	List<Item> findByUserUserId(String userId);
	
//	@Query(value="select * from t_item f "
//			+ "where f.category_no = :categoryNo "
//			+ "ORDER BY f.id \\n#pageable\\n",
//			nativeQuery=true)
	Page<Item> findByItemCategoryCategoryNo(@Param("categoryNo")int categoryNo, @Param("pageable") Pageable pageable);
}
