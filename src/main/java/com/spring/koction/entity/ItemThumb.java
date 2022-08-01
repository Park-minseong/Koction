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
@Table(name="T_ITEM_THUMBNAIL")
@IdClass(ItemThumbId.class)
public class ItemThumb {
	@Id
	private int thumbnailNo;
	
	@Column(nullable = false)
	private String thumbnailOrgNM;
	
	@Column(nullable = false)
	private String thumbnailNm;
	
	@Column(nullable = false)
	private String thumbnailPath;
	
	@Column(nullable = false)
	private LocalDateTime thumbnailRegdate = LocalDateTime.now();
	
	@Id
	@ManyToOne
	@JoinColumn(name="ITEM_NO")
	private Item item;
}