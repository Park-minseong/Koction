package com.spring.koction.service.item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.koction.entity.Item;

public interface ItemService {

	Page<Item> getItemList(Item item, Pageable pageable);

}
