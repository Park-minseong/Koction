package com.spring.koction.service.item.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.koction.entity.Item;
import com.spring.koction.service.item.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	@Override
	public Page<Item> getItemList(Item item, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
