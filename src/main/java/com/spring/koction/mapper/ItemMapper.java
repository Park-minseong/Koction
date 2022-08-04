package com.spring.koction.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.spring.koction.entity.User;

@Mapper
public interface ItemMapper {
	int getNextItemNo();
	
	void updateItemNp(int itemNo);
	
	void updateUserPw(User user);
}
