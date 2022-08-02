package com.spring.koction.service.item;


import com.spring.koction.entity.ItemFile;
import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.koction.entity.Item;

import java.util.List;

public interface ItemService {

	Page<Item> getItemList(Item item, Pageable pageable);

	Item getMyItem(int itemNo);

	void updateItem(Item item);

	List<ItemFile> getItemFileList(int itemNo);

	int regitserItem(Item item);

	void registerItemFile(List<ItemFile> fileList);


}
