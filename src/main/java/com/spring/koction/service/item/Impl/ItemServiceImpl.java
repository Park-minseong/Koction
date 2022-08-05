package com.spring.koction.service.item.Impl;



import com.spring.koction.dto.ItemqDto;
import com.spring.koction.dto.OrderDto;
import com.spring.koction.entity.*;
import com.spring.koction.mapper.ItemMapper;
import com.spring.koction.repository.*;
import com.spring.koction.service.item.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;


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
	public Page<Item> getItemList(Item item, Pageable pageable) {
		return null;
	}

//	@Override
//	public List<Item> getMyItemList() {
//		return null;
//	}

	@Override
	public List<Item> getMyItemList(String userId) {
		return itemRepository.findByUserUserId(userId);
	}

	@Override
	public List<ItemFile> getMyItemFile( ) {
		return itemFileRepository.findAll();
	}

	//??? 이거 뭔가요,, ㅋㅋㅋ 없어서 일단 추가했습니다.
	@Override
	public List<Item> getMyItemList() {
		return null;
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

//	public List<Itemq> selectInquryList(int itemNo) {
////		return itemqRepository.findAll();
//		return itemMapper.selectInquryList(itemNo);
//	}
	public List<ItemqDto> selectInquryList(int itemNo) {
//		return itemqRepository.findAll();
		return itemMapper.selectInquryList(itemNo);
	}


//	@Override
//	public void insertOrder(OrderDto orderDto) {
//		itemMapper.insertOrder(orderDto);
//	}

//	@Override
//	public int insertInquryList(ItemqDto itemq) {
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
	public int insertInqury(Itemq itemq) {
//		itemMapper.insertInquery(itemq);
		int itemqNo = itemMapper.getNextItemqNo();
		itemq.setItemqNo(itemqNo);
		itemqRepository.save(itemq);
		itemqRepository.flush();
		return itemq.getItemqNo();
	}

	@Override
	public void deleteTest(int itemqNo, int itemNo) {
//		ItemqDto itemq = new ItemqDto();
//		Item item = new Item();
//		item.setItemNo(itemNo);
//		itemq.setItem(item);
//		itemq.setItemqNo(itemqNo);

		//itemqRepository.delete(itemq);
		itemMapper.deleteTest(itemqNo, itemNo);
	}

	@Override
	public List<Item> hotProc() {
		
		return itemRepository.findAll();
	}
	
	@Override
	public List<Item> hotProcSort() {
		return itemMapper.hotProcSort();

	}
	
	@Override
	public List<Item> endProc() {
		
		return itemRepository.findAll();
	}
	
	@Override
	public List<Item> endProcSort() {
		return itemMapper.endProcSort();

	}

}
