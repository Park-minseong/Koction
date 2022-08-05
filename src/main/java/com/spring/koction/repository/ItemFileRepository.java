package com.spring.koction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.koction.entity.ItemFile;
import com.spring.koction.entity.ItemFileId;

public interface ItemFileRepository extends JpaRepository<ItemFile, ItemFileId> {

	@Query(value="select ifnull(max(f.itemfile_no), 0)+1 from t_item_file f where f.item_no = :itemNo", nativeQuery=true)
	int selectNextItemNoByItemItemNo(@Param("itemNo") int ItemNo);

	List<ItemFile> findByItemItemNo(int itemNo);
	
}
