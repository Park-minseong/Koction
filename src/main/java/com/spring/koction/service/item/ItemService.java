package com.spring.koction.service.item;


import java.util.List;

import com.spring.koction.entity.Itemq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.koction.entity.Item;
import com.spring.koction.entity.ItemCategory;
import com.spring.koction.entity.ItemFile;
import com.spring.koction.entity.Order;

public interface ItemService {

	Page<Item> getItemList(Item item, Pageable pageable);

	List<Item> getMyItemList();

	void updateItem(Item item);

	List<ItemFile> getItemFileList(int itemNo);

	int registerItem(Item item);

	void registerItemFile(List<ItemFile> fileList);


	List<Order> findOrder(String username);

	List<Item> findCategory(int categoryNo);

	List<ItemCategory> findCategory();

	List<ItemFile> findItemFilesByItemNo(int itemNo);


	List<Itemq> selectInquryList();

	void insertInqury(Itemq itemq);
}
