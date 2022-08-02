package com.spring.koction.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper {
	int getNextItemNo();
	
	void updateItemNp(int itemNo);
}
