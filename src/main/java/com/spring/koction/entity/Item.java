package com.spring.koction.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name="T_ITEM")
@Data
@DynamicInsert
@DynamicUpdate
public class Item {
	@Id
	private int itemNo;
	
	@Column(nullable = false)
	private String itemTitle;
	
	@Column(nullable = false)
	private String itemNm;
	
	@Column(nullable = false)
	private int itemStPrice;
	
	@Column(nullable = false)
	private int itemNbPrice;
	
	@Column(nullable = false)
	@ColumnDefault("(T_ITEM.ITEM_ST_PRICE/20)")
	private int itemBidUnit;
	
	@Column(nullable = false)
	private LocalDateTime itemRegdate = LocalDateTime.now();
	
	@Column(nullable = false)
	private LocalDateTime itemEnddate;
	
	@Column(nullable = false, columnDefinition = "int default 0")
	private int itemBidCnt;
	
	@Column(nullable = false, columnDefinition = "int default 0")
	private int itemCnt;
	
	@Column(nullable = false, columnDefinition = "varchar(1000)")
	private String itemContent;
	
	@Column(nullable = false, columnDefinition = "char(1)")
	private char itemYn ='Y';
	
	@ManyToOne
	@JoinColumn(name="CATEGORY_NO")
	private ItemCategory itemCategory;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	@Transient
	@JsonManagedReference
	private ItemFile itemFile;
		
	@Transient
	private Order order;
	
}
