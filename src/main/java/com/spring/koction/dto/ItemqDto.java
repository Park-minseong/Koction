package com.spring.koction.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;


@Data
public class ItemqDto {

	private int itemqNo;
	private String itemqNm;
	private LocalDateTime itemqRegdate;
	private String itemqContent;
	private char itemqYn;
	private int itemNo;
	private String userId;
}
