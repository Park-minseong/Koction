package com.spring.koction.entity;

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
@Table(name="T_ITEM_FILE")
@IdClass(ItemFileId.class)
public class ItemFile {
	@Id
	private int itemfileNo;
	
	@Column(nullable = false)
	private String itemfileOrgNm;
	
	@Column(nullable = false)
	private String itemfileNm;
	
	@Column(nullable = false)
	private String itemfilePath;
	
	@Id
	@ManyToOne
	@JoinColumn(name="ITEM_NO")
	private Item item;
}
