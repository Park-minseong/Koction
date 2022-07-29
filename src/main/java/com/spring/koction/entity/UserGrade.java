package com.spring.koction.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="T_GRADE")
@Data
public class UserGrade {
	@Id
	private int gradeNo;
	
	@Column(nullable = false)
	private String gradeNm;
}
