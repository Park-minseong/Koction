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
public class Orders {
	@Id
	private int orderNo;
	
	private int orderPrice;
	
	@ManyToOne
	@JoinColumn(name="T_ITEM")
	private Item item;
	
	@Id
	@ManyToOne
	@JoinColumn(name="T_USER")
	private User user;
}
