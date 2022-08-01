package com.spring.koction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.koction.entity.ItemFile;

public interface ItemFileRepository extends JpaRepository<ItemFile, Integer> {

	@Query(value="select ifnull(max(f.itemfile_no), 0)+1 from t_item_file f where f.item_no = :itemNo", nativeQuery=true)
	int selectNextItemNoByItemItemNo(@Param("itemNo") int ItemNo);
}
