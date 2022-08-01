package com.spring.koction.service.item;

import com.spring.koction.entity.ItemFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.koction.entity.Item;

import java.util.List;

public interface ItemService {

	Page<Item> getItemList(Item item, Pageable pageable);

	int registerItem(Item item);

	Item getMyItem(int itemNo);

	void updateItem(Item item);

	void registerItemFileList(List<ItemFile> fileList);

	List<ItemFile> getItemFileList(int itemNo);

}
