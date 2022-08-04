package com.spring.koction.service.item;


import java.util.List;

import com.spring.koction.entity.*;
import com.spring.koction.entity.Itemq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemService {

	Page<Item> getItemList(Item item, Pageable pageable);

	List<Item> getMyItemList(String userId);

	List<ItemFile> getMyItemFile();
	List<Item> getMyItemList();

	void updateItem(Item item);

	List<ItemFile> getItemFileList(int itemNo);

	int registerItem(Item item);

	void registerItemFile(List<ItemFile> fileList);


	List<Order> findOrder(String username);

	Page<Item> findCategory(int categoryNo, Pageable pageable);

	List<ItemCategory> findCategory();

	List<ItemFile> findItemFilesByItemNo(int itemNo);

	void updateItemCnt(int itemNo);

	Item getItem(int itemNo);


	List<Itemq> selectInquryList();

	void insertInqury(Itemq itemq);
}
