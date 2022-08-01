package com.spring.koction.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="T_ITEMQ")
@IdClass(ItemqId.class)
public class Itemq {
	@Id
	private int itemqNo;
	
	@Column(nullable = false)
	private String itemqNm;
	
	@Column(nullable = false)
	private LocalDateTime itemqRegdate = LocalDateTime.now();
	
	@Column(nullable = false, columnDefinition = "varchar(1000)")
	private String itemqContent;
	
	@Column(nullable = false)
	private char itemqYn;
	
	@Id
	@ManyToOne
	@JoinColumn(name="ITEM_NO")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
}
