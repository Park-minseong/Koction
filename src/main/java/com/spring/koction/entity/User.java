package com.spring.koction.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="T_USER")
public class User {
	@Id
	private int userId;
	
	@Column(nullable = false)
	private String userPw;
	
	@Column(nullable = false)
	private String userNm;
	
	@Column(nullable = false)
	private String userTel;
	
	@Column(nullable = false, columnDefinition = "varchar(1000)")
	private String userAddress;
	
	@Column(nullable = false)
	private String userEmail;
	
	@Column(nullable = false ,columnDefinition = "char(1) default 'Y'")
	private char userYn;
	
	@Column(nullable = false ,columnDefinition = "varchar(45) default 'USER'")
	private String role;
	
	@ManyToOne
	@JoinColumn(name="GRADE_NO")
	private UserGrade userGrade;
}
