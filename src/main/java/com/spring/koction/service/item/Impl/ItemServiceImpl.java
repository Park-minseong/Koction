package com.spring.koction.service.item.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.koction.entity.Item;
import com.spring.koction.entity.ItemFile;
import com.spring.koction.mapper.ItemMapper;
import com.spring.koction.repository.ItemFileRepository;
import com.spring.koction.repository.ItemRepository;
import com.spring.koction.service.item.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemMapper itemMapper;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ItemFileRepository itemFileRepository;

	@Override
	public Page<Item> getItemList(Item item, Pageable pageable) {
		return null;
	}

	@Override
	public int regitserItem(Item item) {
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

}
