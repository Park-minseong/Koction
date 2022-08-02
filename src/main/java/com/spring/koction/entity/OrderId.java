package com.spring.koction.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class OrderId implements Serializable {
	private int orderNo;
	private String item;
}
