package com.spring.koction.service.item.Impl;

import com.spring.koction.entity.ItemFile;
import com.spring.koction.repository.ItemRepository;
import com.spring.koction.repository.ItemqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.koction.entity.Item;
import com.spring.koction.service.item.ItemService;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	ItemqRepository itemqRepository;

	@Override
	public Page<Item> getItemList(Item item, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerItem(Item item) {
		itemRepository.save(item);
		itemRepository.flush();
		return item.getItemNo();
	}

	@Override
	public Item getMyItem(int itemNo) {
		return itemRepository.findById(itemNo).get();
	}

	@Override
	public void updateItem(Item item) {
		itemRepository.save(item);
	}

	@Override
	public void registerItemFileList(List<ItemFile> fileList) {
		System.out.println("hello world");
	}

	@Override
	public List<ItemFile> getItemFileList(int itemNo) {
		return null;
	}

}
