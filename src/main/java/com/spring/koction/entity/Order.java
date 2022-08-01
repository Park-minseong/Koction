package com.spring.koction.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="T_ORDER")
@IdClass(OrderId.class)
public class Order {
	@Id
	private int orderNo;
	
	private int orderPrice;
	
	@ManyToOne
	@JoinColumn(name="ITEM_NO")
	private Item item;
	
	@Id
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
}
