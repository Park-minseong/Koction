package com.spring.koction.mapper;

import com.spring.koction.entity.Itemq;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ItemMapper {
	int getNextItemNo();

	void updateItemNp(int itemNo);

	@Select("SELECT IFNULL(MAX(ITEMQ_NO), 0) + 1 FROM T_ITEMQ")
	int getNextInquryNo();

	int getNextItemqNo();

//	@Insert("INSERT INTO ")
//	void insertInquryList();

	//	@Select("SELECT item_no FROM T_ITEMQ WHERE item_no = 1")
//	int getInquryItemNo();
	@Update("UPDATE T_ITEMQ SET ITEMQ_YN='N' WHERE ITEMQ_NO=#{itemqNo} AND ITEM_NO=#{itemNo}")
	void deleteTest(int itemqNo, int itemNo);

//	@Select(SELECT * FROM T_ITEMQ WHERE ITEMQ_YN = 'Y')
}
