package com.spring.koction.service.item.Impl;


import java.util.List;

import com.spring.koction.entity.Itemq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.koction.entity.Item;
import com.spring.koction.entity.ItemCategory;
import com.spring.koction.entity.ItemFile;
import com.spring.koction.entity.Order;
import com.spring.koction.entity.OrderId;
import com.spring.koction.mapper.ItemMapper;
import com.spring.koction.repository.ItemCategoryRepository;
import com.spring.koction.repository.ItemFileRepository;
import com.spring.koction.repository.ItemRepository;
import com.spring.koction.repository.ItemqRepository;
import com.spring.koction.repository.OrderRepository;
import com.spring.koction.service.item.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ItemqRepository itemqRepository;

	@Autowired
	ItemMapper itemMapper;
	
	@Autowired
	ItemFileRepository itemFileRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ItemCategoryRepository itemCategoryRepository;


	@Override
	public List<Item> getMyItemList( ) {
		return itemRepository.findAll();
	}

	@Override
	public void updateItem(Item item) {
		itemRepository.save(item);
	}

	@Override
	public List<ItemFile> getItemFileList(int itemNo) {

		Item item = new Item();
		
		item.setItemNo(itemNo);
		
		List<ItemFile> fileList = itemFileRepository.findByItemItemNo(itemNo);
		
		if(fileList == null || fileList.isEmpty()) {
			return null;
		} else {
			return fileList;
		}

	}
	@Override
	public int registerItem(Item item) {
		int itemNo = itemMapper.getNextItemNo();
		item.setItemNo(itemNo);
		itemRepository.save(item);
		itemRepository.flush();
		return itemNo;
	}

	@Override
	public void registerItemFile(List<ItemFile> fileList) {
		for(ItemFile itemFile : fileList) {
			itemFile.setItemfileNo(itemFileRepository.selectNextItemNoByItemItemNo(itemFile.getItem().getItemNo()));
			itemFileRepository.save(itemFile);
		}
	}

	@Override
	public List<Order> findOrder(String username) {
	
		return orderRepository.findByUserUserId(username);
	}


	@Override
	public Page<Item> findCategory(int categoryNo, Pageable pageable) {
		// TODO Auto-generated method stub
		return itemRepository.findByItemCategoryCategoryNo(categoryNo, pageable);
	}

	@Override
	public List<ItemCategory> findCategory() {
		// TODO Auto-generated method stub
		return itemCategoryRepository.findAll();
	}



	@Override
	public List<ItemFile> findItemFilesByItemNo(int itemNo) {
		return itemFileRepository.findByItemItemNo(itemNo);
	}

	@Override
	public void updateItemCnt(int itemNo) {
		// TODO Auto-generated method stub
		itemMapper.updateItemCnt(itemNo);
		
	}

	@Override
	public Item getItem(int itemNo) {
		// TODO Auto-generated method stub
		return itemRepository.findById(itemNo).get();
	}

	public List<Itemq> selectInquryList() {
		return itemqRepository.findAll();
	}

//	@Override
//	public int insertInquryList(Itemq itemq) {
//		int itemqNo = itemMapper.getNextInquryNo();
//
////		itemq.setItem();
//		itemq.setItemqNo(itemqNo);
////		itemMapper.insertInquryList();
//		itemqRepository.save(itemq);
//		itemqRepository.flush();
//		return itemq.getItemqNo();
//	}

	@Override
	public void insertInqury(Itemq itemq) {
//		itemMapper.insertInquery(itemq);
		itemqRepository.save(itemq);
	}

}
