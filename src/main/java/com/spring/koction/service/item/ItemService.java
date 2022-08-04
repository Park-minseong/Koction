package com.spring.koction.service.item;


import java.util.List;

import com.spring.koction.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemService {

	Page<Item> getItemList(Item item, Pageable pageable);

//	List<Item> getMyItemList();

	List<Item> getMyItemList(String userId);

	List<ItemFile> getMyItemFile();

	void updateItem(Item item);

	List<ItemFile> getItemFileList(int itemNo);

	int registerItem(Item item);

	void registerItemFile(List<ItemFile> fileList);


	List<Order> findOrder(String username);

	List<Item> findCategory(int categoryNo);

	List<ItemCategory> findCategory();

	List<ItemFile> findItemFilesByItemNo(int itemNo);

}
