package com.spring.koction.service.item;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.koction.entity.Item;
import com.spring.koction.entity.ItemFile;

public interface ItemService {

	Page<Item> getItemList(Item item, Pageable pageable);

	List<Item> getMyItemList(String userId);

	void updateItem(Item item);

	List<ItemFile> getItemFileList(int itemNo);

	int registerItem(Item item);

	void registerItemFile(List<ItemFile> fileList);


}
