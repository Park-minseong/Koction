package com.spring.koction.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="T_CATEGORY")
@Data
public class ItemCategory {
	@Id
	private int categoryNo;
	
	@Column(nullable = false)
	private String categoryNm;
}
