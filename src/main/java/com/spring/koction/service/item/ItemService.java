package com.spring.koction.service.item;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.koction.entity.Item;
import com.spring.koction.entity.ItemCategory;
import com.spring.koction.entity.ItemFile;

public interface ItemService {

	Page<Item> getItemList(Item item, Pageable pageable);

	List<Item> getMyItemList();

	void updateItem(Item item);

	List<ItemFile> getItemFileList(int itemNo);

	int registerItem(Item item);

	void registerItemFile(List<ItemFile> fileList);

	List<Item> findCategory(int categoryNo);

	List<ItemCategory> findCategory();

	List<ItemFile> findItemFilesByItemNo(int itemNo);


}
