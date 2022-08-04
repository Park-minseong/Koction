package com.spring.koction.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.spring.koction.entity.User;

@Mapper
public interface ItemMapper {
	int getNextItemNo();
	
	void updateItemNp(int itemNo);
	
	void updateUserPw(User user);


	@Select("SELECT IFNULL(MAX(ITEMQ_NO), 0) + 1 FROM T_ITEMQ")
	int getNextInquryNo();

//	@Insert("INSERT INTO ")
//	void insertInquryList();

//	@Select("SELECT item_no FROM T_ITEMQ WHERE item_no = 1")
//	int getInquryItemNo();
}