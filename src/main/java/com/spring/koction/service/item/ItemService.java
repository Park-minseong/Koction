package com.spring.koction.service.item;

import java.util.List;


import com.spring.koction.dto.ItemqDto;
import com.spring.koction.dto.OrderDto;
import com.spring.koction.entity.Itemq;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.koction.entity.Item;
import com.spring.koction.entity.ItemCategory;
import com.spring.koction.entity.ItemFile;
import com.spring.koction.entity.Order;

public interface ItemService {


	List<Item> hotProc();


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

//	List<Itemq> selectInquryList(int itemNo);


	int insertInqury(Itemq itemq);

	void deleteTest(int itemqNo, int itemNo);


	List<Item> hotProcSort();
	
	List<Item> endProcSort();

	List<Item> endProc();

	List<ItemqDto> selectInquryList(int itemNo);

//	void insertOrder(OrderDto order);
	int insertOrder(Order order);
}
